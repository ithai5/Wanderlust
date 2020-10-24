package com.example.demo.repository;

import com.example.demo.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPackageRepo extends JpaRepository<TravelPackage,Long> {
}