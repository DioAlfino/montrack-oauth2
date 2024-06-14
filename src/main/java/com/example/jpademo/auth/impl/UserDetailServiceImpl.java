package com.example.jpademo.auth.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jpademo.auth.entity.UserAuth;
import com.example.jpademo.user.Repository.UserRepository;
import com.example.jpademo.user.entity.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final  UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existingUser =  userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email not found!")); 
        var userAuth = new UserAuth();
        userAuth.setEmail(existingUser.getEmail());
        userAuth.setPassword(existingUser.getPassword());
        return userAuth;
    }



}   
