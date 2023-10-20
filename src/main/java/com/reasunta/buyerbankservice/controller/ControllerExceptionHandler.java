package com.reasunta.buyerbankservice.controller;

import com.reasunta.buyerbankservice.dto.ErrorDto;
import com.reasunta.buyerbankservice.exception.AccountNotFoundException;
import com.reasunta.buyerbankservice.exception.InsufficientFundsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorDto> handleAccountNotFound(Exception e) {
        return ResponseEntity.badRequest().body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorDto> handleInsufficientFunds(Exception e) {
        return ResponseEntity.badRequest().body(new ErrorDto("Insufficient funds"));
    }
}
