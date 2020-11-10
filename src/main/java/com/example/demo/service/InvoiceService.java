package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepo invoiceRepo;

    public ResponseEntity<List<Invoice>> getAllInvoice(){
        List<Invoice> ls = new ArrayList<>();
        //Return the list and HttpStatus.OK if the list gets populated
        if (ls.addAll(invoiceRepo.findAll())) {
            return new ResponseEntity<>(ls, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    public ResponseEntity<Invoice> findByid(int id){
        Invoice invoice = invoiceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found invoice id = " + id));
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    public Invoice postInvoice(Invoice invoice){
        return invoiceRepo.save(invoice);
    }

    public Invoice patchInvoice(int id, Invoice patch){
        Invoice invoice = invoiceRepo.findById(id).get();
        if (patch == null)
            return null;
        else{
            if (patch.getTotalPeople()!=0)
                invoice.setTotalPeople(patch.getTotalPeople());
            return invoiceRepo.save(invoice);
        }
    }

    public void deleteInvoice(int id){
        try{
            invoiceRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){}
    }
}
