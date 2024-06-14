package com.example.jpademo.pocket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpademo.pocket.PocketRepository;
import com.example.jpademo.pocket.dto.PocketRequestDTO;
import com.example.jpademo.pocket.dto.PocketResponseDTO;
import com.example.jpademo.pocket.entity.Pockets;
import com.example.jpademo.wallet.WalletRepository;
import com.example.jpademo.wallet.entity.Wallet;

@Service
public class PocketServiceImpl implements PocketService{

    @Autowired
    private PocketRepository pocketRepository;
    
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<PocketResponseDTO> getAllPockets() {
        return pocketRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public PocketResponseDTO createPocket(PocketRequestDTO pocketRequestDTO) {
        Wallet wallet = walletRepository.findById(pocketRequestDTO.getWalletId()).orElseThrow(()-> new RuntimeException("wallet not found"));

        Pockets pockets = new Pockets();
        pockets.setName(pocketRequestDTO.getName());
        pockets.setCurrency(pocketRequestDTO.getCurrency());
        pockets.setAmount(pocketRequestDTO.getAmount());
        pockets.setDesc(pocketRequestDTO.getDesc());
        pockets.setWalletId(wallet);
        pockets.setSpent(pocketRequestDTO.getSpent());
        pockets.setEmoji(pocketRequestDTO.getEmoji());

        Pockets savePocket = pocketRepository.save(pockets);
        return convertToDTO(savePocket);
    }

    @Override
    public PocketResponseDTO updatePockets(Long id, PocketRequestDTO pocketRequestDTO) {
        Pockets pocketsDetail = pocketRepository.findById(id).orElseThrow(()-> new RuntimeException("pocket not found"));
        Wallet wallet = walletRepository.findById(pocketRequestDTO.getWalletId()).orElseThrow(()-> new RuntimeException("wallet not found"));
        pocketsDetail.setName(pocketRequestDTO.getName());
        pocketsDetail.setCurrency(pocketRequestDTO.getCurrency());
        pocketsDetail.setAmount(pocketRequestDTO.getAmount());
        pocketsDetail.setDesc(pocketRequestDTO.getDesc());
        pocketsDetail.setWalletId(wallet);
        pocketsDetail.setSpent(pocketRequestDTO.getSpent());
        pocketsDetail.setEmoji(pocketRequestDTO.getEmoji());

        Pockets updatePocket = pocketRepository.save(pocketsDetail);
        return convertToDTO(updatePocket);
    }

    @Override
    public void deletePocket(Long id) {
        pocketRepository.deleteById(id);
    }
    
    private PocketResponseDTO convertToDTO(Pockets pockets) {
        PocketResponseDTO pocketResponseDTO = new PocketResponseDTO();
        pocketResponseDTO.setId(pockets.getId());
        pocketResponseDTO.setName(pockets.getName());
        pocketResponseDTO.setCurrency(pockets.getCurrency());
        pocketResponseDTO.setAmount(pockets.getAmount());
        pocketResponseDTO.setDesc(pockets.getDesc());
        pocketResponseDTO.setWalletId(pockets.getWalletId().getId());
        pocketResponseDTO.setSpent(pockets.getSpent());
        pocketResponseDTO.setEmoji(pockets.getEmoji());

        return pocketResponseDTO;
    }
    

}
