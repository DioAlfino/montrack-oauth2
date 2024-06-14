package com.example.jpademo.pocket.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PocketRequestDTO {

    @NotNull(message = "name cannot be empty")
    private String name;

    @NotNull(message = "currency cannot be empty")
    private String currency;

    @NotNull(message = "amount cannot be empty")
    private Double amount;

    @NotNull(message = "description cannot be empty")
    private String desc;

    @NotNull(message = "walletId cannot be empty")
    private Long walletId;

    @NotNull(message = "spent cannot be empty")
    private Double spent;

    @NotNull(message = "emoji cannot be empty")
    private String emoji;
}
