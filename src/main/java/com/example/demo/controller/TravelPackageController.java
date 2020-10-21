package com.example.demo.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.TravelPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TravelPackageController {

    @Autowired
    TravelPackageRepo travelPackageRepo;

    @GetMapping("/travelPackage")
    public ResponseEntity <List<TravelPackage>> getAllTravelPackage(){
        try{
            List<TravelPackage> lsTravelPackage = new ArrayList<>();
            lsTravelPackage.addAll(travelPackageRepo.findAll());
            return new ResponseEntity<>(lsTravelPackage, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/travelPackage/{id}")
    public Optional<TravelPackage> findById(@PathVariable long id){
        if(travelPackageRepo.findById(id).isPresent())
            return travelPackageRepo.findById(id);
        else
            return null;
    }

    @PostMapping(value = "/travelPackage" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TravelPackage postTravelPackage(@RequestBody TravelPackage travelPackage){
        return travelPackageRepo.save(travelPackage);
    }

    @PatchMapping(path = "/travelPackage/{id}", consumes = "application/json")
    public TravelPackage patchTravelPackage(@PathVariable long id, @RequestBody TravelPackage patch){
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

    @PutMapping("/travelPackage/{id}")
    public TravelPackage putTravelPackage(@RequestBody TravelPackage travelPackage){
        return travelPackageRepo.save(travelPackage);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/TravelPackage/{id}")
    public void deleteTravelPackage(@PathVariable long id){
        try{
            travelPackageRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){}
    }


}
