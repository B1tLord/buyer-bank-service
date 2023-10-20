package com.reasunta.buyerbankservice.controller;

import com.reasunta.buyerbankservice.dto.ClientAccount;
import com.reasunta.buyerbankservice.service.ClientAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Not for production use
 * shows detailed info including account balance
 * more for debug and testing reasons
 */

@RestController
@RequiredArgsConstructor
public class ClientAccountController {
    private final ClientAccountService clientAccountService;

    @GetMapping(value = "accounts/{accountNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientAccount> getAccount(@PathVariable String accountNo) {
        ClientAccount clientAccount = clientAccountService.getAccountInfo(accountNo);
        return ResponseEntity.ok().body(clientAccount);
    }
}
