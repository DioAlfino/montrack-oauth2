package com.example.jpademo.pocket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpademo.pocket.entity.Pockets;

@Repository
public interface PocketRepository extends JpaRepository<Pockets, Long> {   
}
