package com.study.accounts.Application.service;

import com.study.accounts.Application.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto - Customer Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchAccountDetails(String mobileNumber);


    /**
     * @param customerDto - Customer Object containing updated details
     * @return true if account details are successfully updated; otherwise false
     */
    boolean updateAccountDetails(CustomerDto customerDto);


    /**
     * Deletes an account based on the provided mobile number.
     *
     * @param mobileNumber - The mobile number associated with the account to be deleted.
     * @return true if the account is successfully deleted; otherwise false.
     */
    boolean deleteAccount(String mobileNumber);
}
