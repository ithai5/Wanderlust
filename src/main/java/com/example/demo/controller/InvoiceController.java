package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoice")
    public ResponseEntity<List<Invoice>> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice> findByid(@PathVariable("id") int id){
        return invoiceService.findByid(id);
    }

    @PostMapping(value = "/invoice" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice postInvoice(@RequestBody Invoice invoice){
        return invoiceService.postInvoice(invoice);
    }

    @PatchMapping( path = "/invoice/{id}", consumes = "application/json")
    public Invoice patchInvoice(@PathVariable("id") int id, @RequestBody Invoice patch){
        return invoiceService.patchInvoice(id, patch);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("invoice/{id}")
    public void deleteInvoice(@PathVariable("id") int id){
        invoiceService.deleteInvoice(id);
    }


}
