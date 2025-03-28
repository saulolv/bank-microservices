package com.study.accounts.Application.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AccountsDto {

    @NotEmpty(message = "Account number cannot be empty")
    @Digits(integer = 15, fraction = 0, message = "Invalid account number")
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be empty")

    private String accountType;

    @NotEmpty(message = "Branch address cannot be empty")
    private String BranchAddress;
}
