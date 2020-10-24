package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoice {
    private int invoiceId;
    private int totalPeople;
    private int customerId;
    private int travelPackageId;

    @Id
    @Column(name = "invoice_id", nullable = false)
    public int getInvoiceId ()
    {
        return invoiceId;
    }

    public void setInvoiceId (int invoiceId)
    {
        this.invoiceId = invoiceId;
    }

    @Basic
    @Column(name = "total_people", nullable = false)
    public int getTotalPeople ()
    {
        return totalPeople;
    }

    public void setTotalPeople (int totalPeople)
    {
        this.totalPeople = totalPeople;
    }

    @Basic
    @Column(name = "customer_id", nullable = false)
    public int getCustomerId ()
    {
        return customerId;
    }

    public void setCustomerId (int customerId)
    {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "travel_package_id", nullable = false)
    public int getTravelPackageId ()
    {
        return travelPackageId;
    }

    public void setTravelPackageId (int travelPackageId)
    {
        this.travelPackageId = travelPackageId;
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
        if (totalPeople != invoice.totalPeople) {
            return false;
        }
        if (customerId != invoice.customerId) {
            return false;
        }
        if (travelPackageId != invoice.travelPackageId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = invoiceId;
        result = 31 * result + totalPeople;
        result = 31 * result + customerId;
        result = 31 * result + travelPackageId;
        return result;
    }
}
