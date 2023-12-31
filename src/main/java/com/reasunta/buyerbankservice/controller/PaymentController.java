package com.reasunta.buyerbankservice.controller;

import com.reasunta.buyerbankservice.dto.Payment;
import com.reasunta.buyerbankservice.dto.PaymentResult;
import com.reasunta.buyerbankservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping(value = "api/v1/payments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResult> payment(@RequestBody Payment payment) {
        log.info(payment.toString());
        return ResponseEntity.ok().body(paymentService.processPayment(payment));
    }
}
