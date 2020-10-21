package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Transport {
    @Id
    @Column(name = "transport_id")
    private int transportId;

    @Basic
    @Column(name = "t_date")
    private Timestamp tDate;

    @Basic
    @Column(name = "t_type")
    private String tType;

    @Basic
    @Column(name = "t_destination")
    private String tDestination;


    public int getTransportId ()
    {
        return transportId;
    }

    public void setTransportId (int transportId)
    {
        this.transportId = transportId;
    }


    public Timestamp getTDate ()
    {
        return tDate;
    }

    public void setTDate (Timestamp tDate)
    {
        this.tDate = tDate;
    }


    public String getTType ()
    {
        return tType;
    }

    public void setTType (String tType)
    {
        this.tType = tType;
    }


    public String getTDestination ()
    {
        return tDestination;
    }

    public void setTDestination (String tDestination)
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
}
