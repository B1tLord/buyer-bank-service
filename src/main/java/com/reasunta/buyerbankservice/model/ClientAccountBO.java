package com.reasunta.buyerbankservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
