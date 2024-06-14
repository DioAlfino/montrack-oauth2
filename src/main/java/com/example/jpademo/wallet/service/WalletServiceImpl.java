package com.example.jpademo.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpademo.wallet.WalletRepository;
import com.example.jpademo.wallet.entity.Wallet;

@Service
public class WalletServiceImpl implements WalletService {

    
    @Autowired
    private WalletRepository walletRepository;
    
    @Override
    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet updateWallet(Long id, Wallet wallet) {
        Wallet walletDetail = walletRepository.findById(id).orElseThrow(()-> new RuntimeException("wallet no found!")); 
        walletDetail.setName(wallet.getName());
        walletDetail.setBalance(wallet.getBalance());
        walletDetail.setCurrencyId(wallet.getCurrencyId());
        walletDetail.setUserId(wallet.getUserId());
        return walletRepository.save(walletDetail);
    }

    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);;
    }
       
}
