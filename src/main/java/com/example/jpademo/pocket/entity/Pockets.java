package com.example.jpademo.pocket.entity;


import com.example.jpademo.wallet.entity.Wallet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pocket")
@Getter
@Setter
public class Pockets{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    @NotNull(message = "name cannot be empty")
    private String name;

    @Column(name = "currency")
    @NotNull(message = "currency cannot be empty")
    private String currency;

    @NotNull(message = "budget cannot be empty")
    @Column(name = "budget", precision = 20)
    private Double amount;

    @NotNull(message = "description cannot be empty")
    @Column(name = "description", columnDefinition = "text")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet walletId;

    @NotNull(message = "spent cannot be empty")
    @Column(name = "spent", precision = 20)
    private Double spent;

    @NotNull(message = "emoji cannot be empty")
    @Column(name = "emoji")
    private String emoji;
}
