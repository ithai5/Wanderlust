package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Accommodation {
    private int accommodationId;
    private String accName;
    private String accAddress;
    private TravelPackage travelPackageByTravelPackageId;

    public Accommodation ()
    {
    }

    public Accommodation (int accommodationId, String accName, String accAddress, TravelPackage travelPackageByTravelPackageId)
    {
        this.accommodationId = accommodationId;
        this.accName = accName;
        this.accAddress = accAddress;
        this.travelPackageByTravelPackageId = travelPackageByTravelPackageId;
    }

    @Id
    @Column(name = "accommodation_id", nullable = false)
    public int getAccommodationId ()
    {
        return accommodationId;
    }

    public void setAccommodationId (int accommodationId)
    {
        this.accommodationId = accommodationId;
    }

    @Basic
    @Column(name = "acc_name", nullable = false, length = 45)
    public String getAccName ()
    {
        return accName;
    }

    public void setAccName (String accName)
    {
        this.accName = accName;
    }

    @Basic
    @Column(name = "acc_address", nullable = false, length = 100)
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
