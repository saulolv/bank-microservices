package com.study.accounts.Application.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "Mobile number cannot be empty")
    @Size(min = 10, message = "Mobile number must be between 10 and 15 digits")
    @Digits(integer = 15, fraction = 0, message = "Invalid mobile number")
    private String mobileNumber;

    private AccountsDto accounts;
}
