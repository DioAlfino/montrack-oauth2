package com.example.jpademo.pocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpademo.pocket.dto.PocketRequestDTO;
import com.example.jpademo.pocket.dto.PocketResponseDTO;
import com.example.jpademo.pocket.service.PocketService;

@RestController
@RequestMapping("api/v1/pocket")
public class PocketController {
    @Autowired
    private PocketService pocketService;

    @GetMapping
    public ResponseEntity<List<PocketResponseDTO>> getAllPockets(){
        List<PocketResponseDTO> pockets = pocketService.getAllPockets();
        return ResponseEntity.ok(pockets);
    }

    @PostMapping
    public ResponseEntity<PocketResponseDTO> createPocket(@RequestBody PocketRequestDTO pocketRequestDTO) {
        PocketResponseDTO pocketResponseDTO = pocketService.createPocket(pocketRequestDTO);
        return ResponseEntity.ok(pocketResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PocketResponseDTO> updatePocket(@PathVariable Long id, @RequestBody PocketRequestDTO pocketRequestDTO) {
        PocketResponseDTO pocketResponseDTO = pocketService.updatePockets(id, pocketRequestDTO);
        return ResponseEntity.ok(pocketResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePocket(@PathVariable Long id) {
        pocketService.deletePocket(id);
        return ResponseEntity.noContent().build();
    }
}
