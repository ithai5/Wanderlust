package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Accommodation {
    @Id
    @Column(name = "accommodation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accommodationId;

    @Basic
    @Column(name = "acc_name")
    private String accName;

    @Basic
    @Column(name = "acc_address")
    private String accAddress;


    public int getAccommodationId ()
    {
        return accommodationId;
    }

    public void setAccommodationId (int accommodationId)
    {
        this.accommodationId = accommodationId;
    }


    public String getAccName ()
    {
        return accName;
    }

    public void setAccName (String accName)
    {
        this.accName = accName;
    }


    public String getAccAddress ()
    {
        return accAddress;
    }

    public void setAccAddress (String accAddress)
    {
        this.accAddress = accAddress;
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

        Accommodation that = (Accommodation) o;

        if (accommodationId != that.accommodationId) {
            return false;
        }
        if (accName != null ? !accName.equals(that.accName) : that.accName != null) {
            return false;
        }
        if (accAddress != null ? !accAddress.equals(that.accAddress) : that.accAddress != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = accommodationId;
        result = 31 * result + (accName != null ? accName.hashCode() : 0);
        result = 31 * result + (accAddress != null ? accAddress.hashCode() : 0);
        return result;
    }
}
