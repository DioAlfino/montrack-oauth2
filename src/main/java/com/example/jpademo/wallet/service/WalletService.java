package com.example.jpademo.wallet.service;

import java.util.List;

import com.example.jpademo.wallet.entity.Wallet;

public interface WalletService {
    List<Wallet> getAllWallets();
    Wallet createWallet(Wallet wallet);
    Wallet updateWallet(Long id, Wallet wallet);
    void deleteWallet(Long id);
}
