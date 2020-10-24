package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "travel_package")
public class TravelPackage {
    private int travelPackageId;
    private String tpName;
    private int tpPrice;

    @Id
    @Column(name = "travel_package_id", nullable = false)
    public int getTravelPackageId ()
    {
        return travelPackageId;
    }

    public void setTravelPackageId (int travelPackageId)
    {
        this.travelPackageId = travelPackageId;
    }

    @Basic
    @Column(name = "tp_name", nullable = false, length = 30)
    public String getTpName ()
    {
        return tpName;
    }

    public void setTpName (String tpName)
    {
        this.tpName = tpName;
    }

    @Basic
    @Column(name = "tp_price", nullable = false)
    public int getTpPrice ()
    {
        return tpPrice;
    }

    public void setTpPrice (int tpPrice)
    {
        this.tpPrice = tpPrice;
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

        TravelPackage that = (TravelPackage) o;

        if (travelPackageId != that.travelPackageId) {
            return false;
        }
        if (tpPrice != that.tpPrice) {
            return false;
        }
        if (tpName != null ? !tpName.equals(that.tpName) : that.tpName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = travelPackageId;
        result = 31 * result + (tpName != null ? tpName.hashCode() : 0);
        result = 31 * result + tpPrice;
        return result;
    }
}
