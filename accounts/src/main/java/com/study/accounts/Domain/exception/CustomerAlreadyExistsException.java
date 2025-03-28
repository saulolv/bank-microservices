package com.study.accounts.Domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
