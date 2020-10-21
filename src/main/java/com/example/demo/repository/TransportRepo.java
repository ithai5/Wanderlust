package com.example.demo.repository;

import com.example.demo.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepo extends JpaRepository<Transport, Integer> {
}
