package com.example.demo.repository;

import com.example.demo.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
