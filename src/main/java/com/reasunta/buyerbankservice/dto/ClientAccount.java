package com.reasunta.buyerbankservice.dto;

import com.reasunta.buyerbankservice.model.ClientAccountBO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientAccount {
    private final String clientName;
    private final String accountNo;
    private final BigDecimal balance;

    public ClientAccount(ClientAccountBO accountBO) {
        clientName = accountBO.getClientName();
        accountNo = accountBO.getAccountNo();
        balance = accountBO.getBalance();
    }
}
