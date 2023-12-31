package com.reasunta.buyerbankservice.service;

import com.reasunta.buyerbankservice.component.BankConfigParams;
import com.reasunta.buyerbankservice.dto.Bank;
import com.reasunta.buyerbankservice.dto.NotificationDto;
import com.reasunta.buyerbankservice.exception.AccountNotFoundException;
import com.reasunta.buyerbankservice.connector.SellerBankConnector;
import com.reasunta.buyerbankservice.dto.Payment;
import com.reasunta.buyerbankservice.dto.PaymentResult;
import com.reasunta.buyerbankservice.exception.InsufficientFundsException;
import com.reasunta.buyerbankservice.model.ClientAccountBO;
import com.reasunta.buyerbankservice.model.PaymentBO;
import com.reasunta.buyerbankservice.repo.ClientAccountRepo;
import com.reasunta.buyerbankservice.repo.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;

import static com.reasunta.buyerbankservice.enums.PaymentResultType.APPROVED;
import static com.reasunta.buyerbankservice.enums.PaymentResultType.REJECTED;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final ClientAccountRepo clientAccountRepo;
    private final PaymentRepo paymentRepo;
    private final SellerBankConnector sellerBankConnector;
    private final BankConfigParams bankConfigParams;

    @Transactional
    public PaymentResult processPayment(Payment payment) {
        ClientAccountBO account = clientAccountRepo.getByAccountNo(payment.getAccountNo());
        if (account == null)
            throw new AccountNotFoundException(String.format("Account %s not found", payment.getAccountNo()));

        if (payment.getResultType().equals(REJECTED)) {
            try {
                Bank bank = BankConfigParams.fromBankId(payment.getBankId());
                var notification = new NotificationDto(REJECTED, payment.getDescription());
                sellerBankConnector.sendPaymentResult(bank.getUrl(), payment.getReference(), notification);
            } catch (Exception e) {
                /* return REST response anyway even if bank is not available */
            }

            return new PaymentResult(REJECTED);
        }

        if (account.getBalance().compareTo(payment.getAmount()) < 0)
            throw new InsufficientFundsException();

        paymentRepo.save(toPaymentBo(payment, account.getId()));

        BigDecimal newBalance = account.getBalance().subtract(payment.getAmount());
        account.setBalance(newBalance);
        clientAccountRepo.save(account);


        Bank bank = BankConfigParams.fromBankId(payment.getBankId());
        var notification = new NotificationDto(APPROVED, payment.getDescription());
        sellerBankConnector.sendPaymentResult(bank.getUrl(), payment.getReference(), notification);

        return new PaymentResult(APPROVED);
    }

    private PaymentBO toPaymentBo(Payment payment, Long accountId) {
        return PaymentBO.builder()
                .accountId(accountId)
                .amount(payment.getAmount())
                .description(payment.getDescription())
                .reference(payment.getReference())
                .build();
    }
}
