package com.example.demo.controller;

import com.example.demo.model.Transport;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransportController {

    @Autowired
    TransportRepo transportRepo;

    @GetMapping("/transport")
    public ResponseEntity<List<Transport>> getAllTransports(){
        try{
            List<Transport> transportsList = transportRepo.findAll();
            return new ResponseEntity<>(transportsList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*Itai change it
    @GetMapping("/transport/{id}")
    public ResponseEntity<Transport> findTransportById(@PathVariable("id") int id){
        Optional<Transport> transport = transportRepo.findById(id);
        if(transport.isPresent()){
            return new ResponseEntity<>(transport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

 */
    @GetMapping("/transport/{id}")
    public Optional<Transport> findTransportById(@PathVariable("id") int id){
        if(transportRepo.findById(id).isPresent())
            return transportRepo.findById(id);
        else
            return null;
    }

    @PostMapping("/transport")
    public ResponseEntity<Transport> addTransport(@RequestBody Transport transport){
        try {
            Transport newTransport = transportRepo.save(transport);
            return new ResponseEntity<>(newTransport, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(path = "/transport/{id}", consumes = "application/json")
    public Transport patchTransport(@PathVariable("id")  int id, @RequestBody Transport patch){
        Transport transport = transportRepo.findById(id).get();
        if (patch == null)
            return null;
        else{
            if (patch.gettDate() != null)
                transport.settDate(patch.gettDate());
            if (patch.gettDestination() != null)
                transport.settDestination(patch.gettDestination());
            return transportRepo.save(transport);
        }

    }


    //Patch missing?
/*
    @PutMapping("/transport/{id}")
    public ResponseEntity<Transport> editTransport(@PathVariable("id") int id, @RequestBody Transport transport){
        Optional<Transport> transport = transportRepo.findById(id);
        Transport _transport = transportRepo.save(transport);
        return new ResponseEntity<>(_transport, HttpStatus.CREATED);
    }


 */
    @PutMapping("/trasport/{id}")
    public Transport PutTransport(@RequestBody Transport transport){
        return transportRepo.save(transport);
    }

    @DeleteMapping("transport/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransport(@PathVariable("id") int id){
        try {
            transportRepo.deleteById(id);
        } catch (EmptyResultDataAccessException ex){}
    }

}
