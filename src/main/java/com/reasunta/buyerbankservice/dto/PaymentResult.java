package com.reasunta.buyerbankservice.dto;

import com.reasunta.buyerbankservice.enums.PaymentResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentResult {
    private final PaymentResultType resultType;
}
