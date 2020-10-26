package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Customer {
    private int customerId;
    private String cName;
    private Collection<Invoice> invoicesByCustomerId;

    public Customer ()
    {
    }

    public Customer (int customerId, String cName, Collection<Invoice> invoicesByCustomerId)
    {
        this.customerId = customerId;
        this.cName = cName;
        this.invoicesByCustomerId = invoicesByCustomerId;
    }

    @Id
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
    @Column(name = "c_name", nullable = false, length = 45)
    public String getcName ()
    {
        return cName;
    }

    public void setcName (String cName)
    {
        this.cName = cName;
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

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) {
            return false;
        }
        if (cName != null ? !cName.equals(customer.cName) : customer.cName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = customerId;
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Invoice> getInvoicesByCustomerId ()
    {
        return invoicesByCustomerId;
    }

    public void setInvoicesByCustomerId (Collection<Invoice> invoicesByCustomerId)
    {
        this.invoicesByCustomerId = invoicesByCustomerId;
    }
}
