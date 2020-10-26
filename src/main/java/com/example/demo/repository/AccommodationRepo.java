package com.example.demo.repository;

import com.example.demo.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepo extends JpaRepository <Accommodation, Integer> {

}
