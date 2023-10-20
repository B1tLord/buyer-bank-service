package com.reasunta.buyerbankservice.repo;

import com.reasunta.buyerbankservice.model.ClientAccountBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAccountRepo extends JpaRepository<ClientAccountBO, Long> {
    ClientAccountBO getByAccountNo(String accountNo);
}
