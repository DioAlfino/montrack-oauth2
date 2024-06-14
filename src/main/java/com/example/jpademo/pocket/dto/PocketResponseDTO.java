package com.example.jpademo.pocket.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter 
public class PocketResponseDTO {

    private Long id;
    private String name;
    private String currency;
    private Double amount;
    private String desc;
    private Long walletId;
    private Double spent;
    private String emoji;
}
