package com.stock.exchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OperationNotFoundException extends Exception {

    public OperationNotFoundException(String aux) {
        super(String.format("Operation with %s not found in the system.", aux));
    }

    public OperationNotFoundException(Long id) {
        super(String.format("Operation with id %s not found in the system.", id));
    }

}