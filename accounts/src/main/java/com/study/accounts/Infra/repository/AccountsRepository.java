package com.study.accounts.Infra.repository;

import com.study.accounts.Domain.entity.Account;
import com.study.accounts.Domain.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomer(Customer customer);

    @Transactional
    @Modifying
    void deleteAccountsByCustomer(Customer customer);
}
