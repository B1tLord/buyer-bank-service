package com.reasunta.buyerbankservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum Bank {
    SELLER_BANK("seller_bank", "http://10.224.8.138:8888/api/v1/notification"),
    ;

    private final String bankId;
    private final String url;

    private static final Map<String, Bank> bankMap =
            Arrays.stream(Bank.values()).collect(Collectors.toMap(bank -> bank.bankId, Function.identity()));

    public static Bank fromBankId(String bankId) {
        return bankMap.get(bankId);
    }
}
