package com.example.demo.controller;

import com.example.demo.model.FullPackage;
import com.example.demo.repository.FullPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FullPackageController {
    @Autowired
    FullPackageRepo fullPackageRepo;

    @GetMapping("/fullPackage")
    public ResponseEntity<List<FullPackage>> getAllFullPackage(){
        List<FullPackage> ls = new ArrayList<>();
        ls.addAll(fullPackageRepo.findAll());
        return new ResponseEntity<>(ls , HttpStatus.OK);
    }
}
