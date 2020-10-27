package com.example.demo.repository;

import com.example.demo.model.TravelPackage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

@Repository
public interface TravelPackageRepo extends JpaRepository<TravelPackage,Integer> {

    Page<TravelPackage> findAllByTpNameContaining(String tpName, Pageable Paging);
}