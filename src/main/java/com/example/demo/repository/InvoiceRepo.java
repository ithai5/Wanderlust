package com.example.demo.repository;

import com.example.demo.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice, Integer> {
}
