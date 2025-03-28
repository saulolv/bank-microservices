package com.study.accounts.Application.service.impl;

import com.study.accounts.constants.AccountsConstants;
import com.study.accounts.Application.dto.AccountsDto;
import com.study.accounts.Application.dto.CustomerDto;
import com.study.accounts.Domain.entity.Account;
import com.study.accounts.Domain.entity.Customer;
import com.study.accounts.Domain.exception.CustomerAlreadyExistsException;
import com.study.accounts.Domain.exception.ResourceNotFoundException;
import com.study.accounts.Application.mapper.AccountsMapper;
import com.study.accounts.Application.mapper.CustomerMapper;
import com.study.accounts.Infra.repository.AccountsRepository;
import com.study.accounts.Infra.repository.CustomerRepository;
import com.study.accounts.Application.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountsService implements IAccountsService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(
                    String.format("Customer with mobile number %s already exists", customerDto.getMobileNumber()));
        }

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Customer savedCustomer = customerRepository.save(customer);

        accountsRepository.save(createAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        Account account = accountsRepository.findByCustomer(customer).orElseThrow(() -> new ResourceNotFoundException("Account", "customer", mobileNumber));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccounts(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));

        return customerDto;
    }

    @Override
    public boolean updateAccountDetails(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccounts();

        if (accountsDto != null) {
            Account account = accountsRepository.findById(accountsDto.getAccountNumber())
                    .orElseThrow( () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString()));

            AccountsMapper.mapToAccount(accountsDto, account);
            account = accountsRepository.save(account);


            Customer customer = account.getCustomer();
            if (customer == null) {
                throw new ResourceNotFoundException("Customer", "associated with account", accountsDto.getAccountNumber().toString());
            }

            CustomerMapper.mapToCustomer(customerDto, customer);
            customerRepository.save(customer);

            return !isUpdated;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        accountsRepository.deleteAccountsByCustomer(customer);
        customerRepository.delete(customer);

        return true;
    }

    private Account createAccount(Customer customer) {

        Account account = new Account();
        account.setCustomer(customer);

        long randomAccountNumber = (long) (Math.random() * 1000000000);
        account.setAccountNumber(randomAccountNumber);

        account.setAccountType(AccountsConstants.SAVINGS);
        account.setBranchAddress(AccountsConstants.ADDRESS);

        return account;
    }
}
