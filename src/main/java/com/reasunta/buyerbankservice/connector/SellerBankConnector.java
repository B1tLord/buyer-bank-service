package com.reasunta.buyerbankservice.connector;

import com.reasunta.buyerbankservice.dto.NotificationDto;
import com.reasunta.buyerbankservice.enums.PaymentResultType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class SellerBankConnector {
    private final RestTemplate restTemplate;

    public void sendPaymentResult(String endpoint, String reference, NotificationDto notificationDto) {
        String uri = StringUtils.trimTrailingCharacter(endpoint, '/') + '/' + reference;
        restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(notificationDto), Void.class);
    }
}
