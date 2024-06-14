package com.example.jpademo.wallet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jpademo.response.ApiResponse;
import com.example.jpademo.wallet.entity.Wallet;
import com.example.jpademo.wallet.service.WalletService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Wallet>>> getAllWallets() {
        List<Wallet> allWallet = walletService.getAllWallets();
        ApiResponse<List<Wallet>> response = new ApiResponse<>("succsess", "all data", allWallet);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Wallet>> createWallet(@Valid @RequestBody Wallet wallet) {
        Wallet saveWallet = walletService.createWallet(wallet);
        ApiResponse<Wallet> response = new ApiResponse<Wallet>("succsess", "wallet created succsessfully", saveWallet);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Wallet>> updatWallet(@PathVariable Long id, @RequestBody Wallet wallet) {
        Wallet updatedWallet = walletService.updateWallet(id, wallet);
        ApiResponse<Wallet> response = new ApiResponse<Wallet>("succsess", "data succsessfully updated", updatedWallet);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        
    @DeleteMapping("/{id}")
    public void deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
    }
        
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<ApiResponse<Void>> handleValidationException (MethodArgumentNotValidException ex){
        StringBuilder errorMessage = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String errorMsg = error.getDefaultMessage();
            errorMessage.append(errorMsg).append(", ");
        }); 
        ApiResponse<Void> response = new ApiResponse<Void>("error",errorMessage.toString(), null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
            