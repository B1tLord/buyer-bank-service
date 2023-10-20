package com.reasunta.buyerbankservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class PaymentBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long accountId;

    @Column
    @CreationTimestamp
    private LocalDateTime transDate;

    @Column
    private BigDecimal amount;

    @Column
    private String reference;

    @Column
    private String description;
}
