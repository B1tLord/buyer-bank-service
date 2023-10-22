package com.reasunta.buyerbankservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "CLIENT_ACCOUNT")
@Getter
@Setter
public class ClientAccountBO {
    @Id
    @Column
    private Long id;

    @Column
    private String clientName;

    @Column
    private String accountNo;

    @Column
    private BigDecimal balance;
}
