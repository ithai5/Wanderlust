package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        super();
        this.customerRepo=customerRepo;
    }

    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> ls = new ArrayList<>();
        ls.addAll(customerRepo.findAll());
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    public ResponseEntity<Customer> findById(int id) {
        Customer customer = customerRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found customer id = " + id));
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    public Customer postCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer patchCustomer(int id, Customer patch)
    {
        Customer customer = customerRepo.findById(id).get();
        if (patch == null)
            return null;
        else {
            if (patch.getcName() != null)
                customer.setcName(patch.getcName());

        }
        return customerRepo.save(customer);
    }

    public void deleteCustomer(int id){
        try{
            customerRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){}
    }

}
