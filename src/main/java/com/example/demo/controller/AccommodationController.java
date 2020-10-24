package com.example.demo.controller;

import com.example.demo.model.Accommodation;
import com.example.demo.repository.AccommodationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccommodationController {

    @Autowired
    AccommodationRepo accommodationRepo;

    @GetMapping("/accommodation")
    public ResponseEntity<List<Accommodation>> getAllAccommodation(){
        try{
            List<Accommodation> lsAccommodation = new ArrayList<>();
            lsAccommodation.addAll(accommodationRepo.findAll());
            return new ResponseEntity<>(lsAccommodation, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/accommodation/{id}")
    public Optional<Accommodation> findById(@PathVariable ("id") int id){
        if( accommodationRepo.findById(id).isPresent())
            return accommodationRepo.findById(id);
        else
            return null;
    }

    @PostMapping(value = "/accommodation" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Accommodation postAccommodation (@RequestBody Accommodation accommodation){
        return accommodationRepo.save(accommodation);
    }

    @PatchMapping(path = "accommodation/{id}" , consumes = "application/json")
    public Accommodation putAccommodation (@PathVariable ("id")  int id, @RequestBody Accommodation patch ){
        Accommodation accommodation = accommodationRepo.findById(id).get();
        if (accommodation == null)
            return null;
        else {
            if (patch.getAccAddress() !=null){
                accommodation.setAccAddress(patch.getAccAddress());
            }
            if (patch.getAccName()!= null){
                accommodation.setAccName(patch.getAccName());
            }
            return accommodationRepo.save(accommodation);
        }
    }

    @PutMapping("accommodation/{id}")
    public Accommodation putAccommodation(@RequestBody Accommodation accommodation){
        return accommodationRepo.save(accommodation);
    }
}
