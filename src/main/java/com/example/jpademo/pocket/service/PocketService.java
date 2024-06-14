package com.example.jpademo.pocket.service;

import java.util.List;

import com.example.jpademo.pocket.dto.PocketRequestDTO;
import com.example.jpademo.pocket.dto.PocketResponseDTO;

public interface PocketService {
    List<PocketResponseDTO> getAllPockets();
    PocketResponseDTO createPocket(PocketRequestDTO pocketRequestDTO);
    PocketResponseDTO updatePockets(Long id, PocketRequestDTO pocketRequestDTO);
    void deletePocket(Long id);
}
