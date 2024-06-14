package com.example.jpademo.wallet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wallet")
@Setter
@Getter
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @PositiveOrZero(message = "negative is forbidden")
    @Column(name = "balance", precision = 20)
    @NotNull(message = "balance cannot be empty")

    private Double balance;

    @Column(name = "name", length = 100)
    @NotNull(message = "Name cannot be empty")
    private String name;

    @Column(name = "currency_id")
    private Long currencyId;
}
