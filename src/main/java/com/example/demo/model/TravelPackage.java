package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "travel_package", schema = "wanderlust", catalog = "")
public class TravelPackage {
    private int travelPackageId;
    private String tpName;
    private int tpPrice;
    private Collection<Accommodation> accommodationsByTravelPackageId;
    private Collection<Activity> activitiesByTravelPackageId;
    private Collection<Invoice> invoicesByTravelPackageId;
    private Collection<Transport> transportsByTravelPackageId;

    public TravelPackage ()
    {
    }

    public TravelPackage (int travelPackageId, String tpName, int tpPrice, Collection<Accommodation> accommodationsByTravelPackageId, Collection<Activity> activitiesByTravelPackageId, Collection<Invoice> invoicesByTravelPackageId, Collection<Transport> transportsByTravelPackageId)
    {
        this.travelPackageId = travelPackageId;
        this.tpName = tpName;
        this.tpPrice = tpPrice;
        this.accommodationsByTravelPackageId = accommodationsByTravelPackageId;
        this.activitiesByTravelPackageId = activitiesByTravelPackageId;
        this.invoicesByTravelPackageId = invoicesByTravelPackageId;
        this.transportsByTravelPackageId = transportsByTravelPackageId;
    }

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

    @OneToMany(mappedBy = "travelPackageByTravelPackageId")
    public Collection<Accommodation> getAccommodationsByTravelPackageId ()
    {
        return accommodationsByTravelPackageId;
    }

    public void setAccommodationsByTravelPackageId (Collection<Accommodation> accommodationsByTravelPackageId)
    {
        this.accommodationsByTravelPackageId = accommodationsByTravelPackageId;
    }

    @OneToMany(mappedBy = "travelPackageByTravelPackageId")
    public Collection<Activity> getActivitiesByTravelPackageId ()
    {
        return activitiesByTravelPackageId;
    }

    public void setActivitiesByTravelPackageId (Collection<Activity> activitiesByTravelPackageId)
    {
        this.activitiesByTravelPackageId = activitiesByTravelPackageId;
    }

    @OneToMany(mappedBy = "travelPackageByTravelPackageId")
    public Collection<Invoice> getInvoicesByTravelPackageId ()
    {
        return invoicesByTravelPackageId;
    }

    public void setInvoicesByTravelPackageId (Collection<Invoice> invoicesByTravelPackageId)
    {
        this.invoicesByTravelPackageId = invoicesByTravelPackageId;
    }

    @OneToMany(mappedBy = "travelPackageByTravelPackageId")
    public Collection<Transport> getTransportsByTravelPackageId ()
    {
        return transportsByTravelPackageId;
    }

    public void setTransportsByTravelPackageId (Collection<Transport> transportsByTravelPackageId)
    {
        this.transportsByTravelPackageId = transportsByTravelPackageId;
    }
}
