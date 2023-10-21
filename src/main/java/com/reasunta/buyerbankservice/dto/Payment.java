package com.reasunta.buyerbankservice.dto;

import com.reasunta.buyerbankservice.enums.PaymentResultType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Payment {
    private String reference;
    private String accountNo;
    private BigDecimal amount;
    private String bankId;
    private String description;
    private PaymentResultType resultType;
}
