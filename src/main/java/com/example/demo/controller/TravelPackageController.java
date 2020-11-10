package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TravelPackage;
import com.example.demo.service.TravelPackageService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.repository.TravelPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TravelPackageController {

    private final TravelPackageService travelPackageService;
    @Autowired
    public TravelPackageController(TravelPackageService travelPackageService){
        this.travelPackageService = travelPackageService;
    }

    @GetMapping("/travelPackage")
    public ResponseEntity <List<TravelPackage>> getAllTravelPackage(){
        return travelPackageService.getAllTravelPackage();
    }

    @GetMapping("/travelPackage/{id}")
    public ResponseEntity<TravelPackage> findById(@PathVariable("id")  int id){
        return travelPackageService.findById(id);
    }

    @PostMapping(value = "/travelPackage" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TravelPackage postTravelPackage(@RequestBody TravelPackage travelPackage){
        return travelPackageService.postTravelPackage(travelPackage);
    }

    @PatchMapping(path = "/travelPackage/{id}", consumes = "application/json")
    public TravelPackage patchTravelPackage(@PathVariable("id")  int id, @RequestBody TravelPackage patch){
        return travelPackageService.patchTravelPackage(id, patch);
    }


    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/TravelPackage/{id}")
    public void deleteTravelPackage(@PathVariable("id")  int id){
        travelPackageService.deleteTravelPackage(id);
    }
    @GetMapping("/travelPackage/pageAndSort")
    public ResponseEntity<Map<String, Object>> getPageAndSort(
            @RequestParam(required = false) String tpName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size,
            @RequestParam(defaultValue = "tpPrice,desc") String[]sort) {
        return travelPackageService.getPageAndSort(tpName,page,size,sort);
    }
}
