package com.reasunta.buyerbankservice.component;

import com.reasunta.buyerbankservice.dto.Bank;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties(prefix = "service")
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class BankConfigParams {
    private List<Bank> banks;


    private static Map<String, Bank> bankMap;

    @PostConstruct
    public void init() {
        bankMap = banks.stream().collect(Collectors.toMap(Bank::getBankId, Function.identity()));
    }

    public static Bank fromBankId(String bankId) {
        return bankMap.get(bankId);
    }
}
