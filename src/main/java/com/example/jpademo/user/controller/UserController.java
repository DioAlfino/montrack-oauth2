package com.example.jpademo.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpademo.response.Response;
import com.example.jpademo.user.dto.RegisterRequestDto;
import com.example.jpademo.user.entity.User;
import com.example.jpademo.user.service.UserService;

import jakarta.annotation.security.RolesAllowed;


@RestController
@RequestMapping("/api/v1/user")
@Validated
public class UserController {

    private final UserService userService;
    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;

    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterRequestDto registerRequestDto) {
        return Response.success("user registered successfully", userService.register(registerRequestDto));
    }

    @RolesAllowed(
        value = {"ROLE_USER", "ROLE_ADMIN"}
    )

    @GetMapping
    public ResponseEntity<?> profile(@PathVariable String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
