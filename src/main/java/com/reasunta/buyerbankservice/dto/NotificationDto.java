package com.reasunta.buyerbankservice.dto;

import com.reasunta.buyerbankservice.enums.PaymentResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    private PaymentResultType status;
    private String content;
}
