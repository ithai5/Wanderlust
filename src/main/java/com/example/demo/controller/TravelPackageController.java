package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TravelPackage;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.repository.TravelPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelPackageController {

    @Autowired
    TravelPackageRepo travelPackageRepo;

    @GetMapping("/travelPackage")
    public ResponseEntity <List<TravelPackage>> getAllTravelPackage(){
        List<TravelPackage> lsTravelPackage = new ArrayList<>();
        lsTravelPackage.addAll(travelPackageRepo.findAll());
        return new ResponseEntity<>(lsTravelPackage, HttpStatus.OK);

    }

    @GetMapping("/travelPackage/{id}")
    public ResponseEntity<TravelPackage> findById(@PathVariable("id")  int id){
        TravelPackage travelPackage = travelPackageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found travelPackage id = " + id));
        return new ResponseEntity<>(travelPackage, HttpStatus.OK);
    }

    @PostMapping(value = "/travelPackage" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TravelPackage postTravelPackage(@RequestBody TravelPackage travelPackage){
        return travelPackageRepo.save(travelPackage);
    }

    @PatchMapping(path = "/travelPackage/{id}", consumes = "application/json")
    public TravelPackage patchTravelPackage(@PathVariable("id")  int id, @RequestBody TravelPackage patch){
        TravelPackage travelPackage = travelPackageRepo.findById(id).get();
        if (patch == null)
            return null;
        else{
            if (patch.getTpName() != null)
                travelPackage.setTpName(patch.getTpName());
            if (patch.getTpPrice() != 0)
                travelPackage.setTpPrice(patch.getTpPrice());
            return travelPackageRepo.save(travelPackage);
        }

    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/TravelPackage/{id}")
    public void deleteTravelPackage(@PathVariable("id")  int id){
        try{
            travelPackageRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){}
    }


}
