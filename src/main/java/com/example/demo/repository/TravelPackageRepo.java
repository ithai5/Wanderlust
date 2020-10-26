package com.example.demo.repository;

import com.example.demo.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRepo extends JpaRepository<TravelPackage,Integer> {
}