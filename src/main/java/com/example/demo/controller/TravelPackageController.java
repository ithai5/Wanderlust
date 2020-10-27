package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TravelPackage;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
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

    @GetMapping("travelPackage/sorted")
    public ResponseEntity<List<TravelPackage>> getAllTravelPackagesSorted(@RequestParam(defaultValue = "tpPrice,desc") String[]sort){
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        //sort=[field, direction]
        orders.add(new Sort.Order(getSortDirection(sort[1]),sort[0]));

        List<TravelPackage> travelPackages = travelPackageRepo.findAll(Sort.by(orders));
        if(travelPackages.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else{
            return new ResponseEntity<>(travelPackages, HttpStatus.OK);
        }
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.DESC;
    }
}
