package com.example.jpademo.user.service;

import java.util.List;

import com.example.jpademo.user.dto.RegisterRequestDto;
import com.example.jpademo.user.entity.User;

public interface UserService {

    User register(RegisterRequestDto user);
    User findByEmail(String email);
    User findById(Long id);
    List<User> findall();
    void deletedBy(Long id);
    User profile();

}
