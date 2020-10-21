package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoice {

    @Id
    @Column(name = "invoice_id")
    private int invoiceId;

    @Basic
    @Column(name = "total_people")
    private String totalPeople;


    public int getInvoiceId ()
    {
        return invoiceId;
    }

    public void setInvoiceId (int invoiceId)
    {
        this.invoiceId = invoiceId;
    }


    public String getTotalPeople ()
    {
        return totalPeople;
    }

    public void setTotalPeople (String totalPeople)
    {
        this.totalPeople = totalPeople;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Invoice invoice = (Invoice) o;

        if (invoiceId != invoice.invoiceId) {
            return false;
        }
        if (totalPeople != null ? !totalPeople.equals(invoice.totalPeople) : invoice.totalPeople != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = invoiceId;
        result = 31 * result + (totalPeople != null ? totalPeople.hashCode() : 0);
        return result;
    }
}
