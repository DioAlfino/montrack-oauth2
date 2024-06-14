package com.example.jpademo.user.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpademo.user.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{    

    Optional<User> findByEmail(String email);
}
