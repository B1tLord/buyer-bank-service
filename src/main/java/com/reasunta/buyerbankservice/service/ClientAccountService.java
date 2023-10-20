package com.reasunta.buyerbankservice.service;

import com.reasunta.buyerbankservice.dto.ClientAccount;
import com.reasunta.buyerbankservice.model.ClientAccountBO;
import com.reasunta.buyerbankservice.repo.ClientAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientAccountService {
    private final ClientAccountRepo clientAccountRepo;

    public ClientAccount getAccountInfo(String accountNo) {
        ClientAccountBO accountBO = clientAccountRepo.getByAccountNo(accountNo);
        return new ClientAccount(accountBO);
    }
}
