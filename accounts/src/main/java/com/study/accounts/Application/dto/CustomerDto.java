package com.study.accounts.Application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
@Data
public class CustomerDto {

    @Schema(
            description = "Name of the customer",
            example = "John Doe"
    )
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "john@gmail.com"
    )
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "1234567890"
    )
    @NotEmpty(message = "Mobile number cannot be empty")
    @Size(min = 10, message = "Mobile number must be between 10 and 15 digits")
    @Digits(integer = 15, fraction = 0, message = "Invalid mobile number")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accounts;
}
