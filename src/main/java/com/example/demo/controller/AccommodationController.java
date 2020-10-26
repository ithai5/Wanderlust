package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Accommodation;
import com.example.demo.repository.AccommodationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccommodationController {

    @Autowired
    AccommodationRepo accommodationRepo;

    @GetMapping("/accommodation")
    public ResponseEntity<List<Accommodation>> getAllAccommodation(){
        List<Accommodation> lsAccommodation = new ArrayList<>();
        lsAccommodation.addAll(accommodationRepo.findAll());

        return new ResponseEntity<>(lsAccommodation, HttpStatus.OK);
    }

    @GetMapping("/accommodation/{id}")
    public ResponseEntity<Accommodation> getAccommodationById(@PathVariable("id") int id){
        Accommodation accommodation = accommodationRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not found accommodation with id = " +id));
        return new ResponseEntity<>(accommodation,HttpStatus.OK);
    }



    @PostMapping(value = "/accommodation" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Accommodation postAccommodation (@RequestBody Accommodation accommodation){
        return accommodationRepo.save(accommodation);
    }

    @PatchMapping(path = "accommodation/{id}" , consumes = "application/json")
    public Accommodation putAccommodation (@PathVariable ("id")  int id, @RequestBody Accommodation patch ){
        Accommodation accommodation = accommodationRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not found accommodation with id = " + id));
            if (patch.getAccAddress() !=null){
                accommodation.setAccAddress(patch.getAccAddress());
            }
            if (patch.getAccName()!= null){
                accommodation.setAccName(patch.getAccName());
            }
            return accommodationRepo.save(accommodation);
    }

    @PutMapping("accommodation/{id}")
    public Accommodation putAccommodation(@RequestBody Accommodation accommodation){
        return accommodationRepo.save(accommodation);
    }
}
