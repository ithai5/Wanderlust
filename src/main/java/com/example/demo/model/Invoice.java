package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Invoice {
    private int invoiceId;
    private int totalPeople;
    private Customer customerByCustomerId;
    private TravelPackage travelPackageByTravelPackageId;

    public Invoice ()
    {
    }

    public Invoice (int invoiceId, int totalPeople, Customer customerByCustomerId, TravelPackage travelPackageByTravelPackageId)
    {
        this.invoiceId = invoiceId;
        this.totalPeople = totalPeople;
        this.customerByCustomerId = customerByCustomerId;
        this.travelPackageByTravelPackageId = travelPackageByTravelPackageId;
    }

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

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = invoiceId;
        result = 31 * result + totalPeople;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public Customer getCustomerByCustomerId ()
    {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId (Customer customerByCustomerId)
    {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "travel_package_id", referencedColumnName = "travel_package_id", nullable = false)
    public TravelPackage getTravelPackageByTravelPackageId ()
    {
        return travelPackageByTravelPackageId;
    }

    public void setTravelPackageByTravelPackageId (TravelPackage travelPackageByTravelPackageId)
    {
        this.travelPackageByTravelPackageId = travelPackageByTravelPackageId;
    }
}
