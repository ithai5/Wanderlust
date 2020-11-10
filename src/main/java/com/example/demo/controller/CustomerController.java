package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService  =customerService;
    }


    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") int id){
;       return customerService.findById(id);
    }

    @PostMapping(value = "/customer" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer postCustomer(@RequestBody Customer customer){
        return customerService.postCustomer(customer);
    }

    @PatchMapping(path =  "/customer/{id}" , consumes = "application/json")
    public Customer patchCustomer(@PathVariable("id") int id,  @RequestBody Customer patch){
            return customerService.patchCustomer(id, patch);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("customer/{id}")
    public void deleteCustomer(@PathVariable("id") int id){
        customerService.deleteCustomer(id);
    }
}
