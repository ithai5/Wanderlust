package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Transport {
    private int transportId;
    private Timestamp tDate;
    private String tType;
    private String tDestination;
    private TravelPackage travelPackageByTravelPackageId;

    public Transport ()
    {
    }

    public Transport (int transportId, Timestamp tDate, String tType, String tDestination, TravelPackage travelPackageByTravelPackageId)
    {
        this.transportId = transportId;
        this.tDate = tDate;
        this.tType = tType;
        this.tDestination = tDestination;
        this.travelPackageByTravelPackageId = travelPackageByTravelPackageId;
    }

    @Id
    @Column(name = "transport_id", nullable = false)
    public int getTransportId ()
    {
        return transportId;
    }

    public void setTransportId (int transportId)
    {
        this.transportId = transportId;
    }

    @Basic
    @Column(name = "t_date", nullable = false)
    public Timestamp gettDate ()
    {
        return tDate;
    }

    public void settDate (Timestamp tDate)
    {
        this.tDate = tDate;
    }

    @Basic
    @Column(name = "t_type", nullable = false, length = 45)
    public String gettType ()
    {
        return tType;
    }

    public void settType (String tType)
    {
        this.tType = tType;
    }

    @Basic
    @Column(name = "t_destination", nullable = false, length = 45)
    public String gettDestination ()
    {
        return tDestination;
    }

    public void settDestination (String tDestination)
    {
        this.tDestination = tDestination;
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

        Transport transport = (Transport) o;

        if (transportId != transport.transportId) {
            return false;
        }
        if (tDate != null ? !tDate.equals(transport.tDate) : transport.tDate != null) {
            return false;
        }
        if (tType != null ? !tType.equals(transport.tType) : transport.tType != null) {
            return false;
        }
        if (tDestination != null ? !tDestination.equals(transport.tDestination) : transport.tDestination != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = transportId;
        result = 31 * result + (tDate != null ? tDate.hashCode() : 0);
        result = 31 * result + (tType != null ? tType.hashCode() : 0);
        result = 31 * result + (tDestination != null ? tDestination.hashCode() : 0);
        return result;
    }

    @JsonBackReference
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
