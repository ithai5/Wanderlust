package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepo;
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
public class InvoiceController {

    @Autowired
    InvoiceRepo invoiceRepo;

    @GetMapping("/invoice")
    public ResponseEntity<List<Invoice>> getAllInvoice(){
        List<Invoice> ls = new ArrayList<>();
        ls.addAll(invoiceRepo.findAll());
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice> findByid(@PathVariable("id") int id){
        Invoice invoice = invoiceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found invoice id = " + id));
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @PostMapping(value = "/invoice" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice postInvoice(@RequestBody Invoice invoice){
        return invoiceRepo.save(invoice);
    }

    @PatchMapping( path = "/invoice/{id}", consumes = "application/json")
    public Invoice patchInvoice(@PathVariable("id") int id, @RequestBody Invoice patch){
        Invoice invoice = invoiceRepo.findById(id).get();
        if (patch ==null)
            return null;
        else{
            if (patch.getTotalPeople()!=0)
                invoice.setTotalPeople(patch.getTotalPeople());
            return invoiceRepo.save(invoice);
        }
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("invoice/{id}")
    public void deleteInvoice(@PathVariable("id") int id){
        try{
            invoiceRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){}
    }


}
