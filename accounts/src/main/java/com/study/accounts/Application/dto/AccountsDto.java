package com.study.accounts.Application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information")
@Data
public class AccountsDto {

    @Schema(
            description = "Account number of the customer"
    )
    @NotEmpty(message = "Account number cannot be empty")
    @Digits(integer = 15, fraction = 0, message = "Invalid account number")
    private Long accountNumber;

    @Schema(
            description = "Account type of the customer",
            example = "Savings"
    )
    @NotEmpty(message = "Account type cannot be empty")
    private String accountType;

    @Schema(
            description = "Branch name of the customer",
            example = "Main Branch"
    )
    @NotEmpty(message = "Branch address cannot be empty")
    private String branchAddress;
}
