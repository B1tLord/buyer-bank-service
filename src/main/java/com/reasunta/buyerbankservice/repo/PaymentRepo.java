package com.reasunta.buyerbankservice.repo;

import com.reasunta.buyerbankservice.model.PaymentBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentBO, Long> {
}
