package com.reasunta.buyerbankservice.dto;

import com.reasunta.buyerbankservice.enums.PaymentResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Payment {
    private final String reference;
    private final String accountNo;
    private final BigDecimal amount;
    private final String bankId;
    private final String description;
    private final PaymentResultType resultType;
}
