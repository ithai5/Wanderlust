package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    private int customerId;
    private String cName;

    @Id
    @Column(name = "customer_id")
    public int getCustomerId ()
    {
        return customerId;
    }

    public void setCustomerId (int customerId)
    {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "c_name")
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
}
