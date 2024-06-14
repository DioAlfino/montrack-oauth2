package com.example.jpademo.user.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jpademo.exception.ApplicationException;
import com.example.jpademo.user.Repository.UserRepository;
import com.example.jpademo.user.dto.RegisterRequestDto;
import com.example.jpademo.user.entity.User;
import com.example.jpademo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(RegisterRequestDto user) {
        User newUser = user.toEntity();
        var password = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }   

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ApplicationException("User not found"));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new ApplicationException("user not found"));
    }

    @Override
    public List<User> findall() {
        return null;
    }

    @Override
    public void deletedBy(Long id) {
    }

    @Override
    public User profile() {
        return null;
    }

  

}
