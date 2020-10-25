package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        try{
            List<Customer> ls = new ArrayList<>();
            ls.addAll(customerRepo.findAll());
            return new ResponseEntity<>(ls, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("customer/{id}")
    public Optional<Customer> findById(@PathVariable("id") int id){
        if(customerRepo.findById(id).isPresent())
            return customerRepo.findById(id);
        else
            return null;
    }

    @PostMapping(value = "/customer" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer postCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }

    @PatchMapping(path =  "/customer/{id}" , consumes = "application/json")
    public Customer patchCustomer(@PathVariable("id") int id,  @RequestBody Customer patch){
        Customer customer = customerRepo.findById(id).get();
        if(patch == null)
            return null;
        else {
            if(patch.getcName()!= null)
                customer.setcName(patch.getcName());
            return customerRepo.save(customer);
        }
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("customer/{id}")
    public void deleteCustomer(@PathVariable("id") int id){
        try{
            customerRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){}
    }
}
