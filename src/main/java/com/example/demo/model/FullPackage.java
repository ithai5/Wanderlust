package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "full_package", schema = "wanderlust", catalog = "")
public class FullPackage {
    @Id
    private String tpName;
    private int tpPrice;
    private String aName;
    private String aDescription;
    private Timestamp tDate;
    private String tType;
    private String tDestination;
    private String accName;
    private String accAddress;

    public FullPackage ()
    {
    }

    public FullPackage (String tpName, int tpPrice, String aName, String aDescription, Timestamp tDate, String tType, String tDestination, String accName, String accAddress)
    {
        this.tpName = tpName;
        this.tpPrice = tpPrice;
        this.aName = aName;
        this.aDescription = aDescription;
        this.tDate = tDate;
        this.tType = tType;
        this.tDestination = tDestination;
        this.accName = accName;
        this.accAddress = accAddress;
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

    @Basic
    @Column(name = "a_name", nullable = false, length = 45)
    public String getaName ()
    {
        return aName;
    }

    public void setaName (String aName)
    {
        this.aName = aName;
    }

    @Basic
    @Column(name = "a_description", nullable = false, length = 255)
    public String getaDescription ()
    {
        return aDescription;
    }

    public void setaDescription (String aDescription)
    {
        this.aDescription = aDescription;
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

        FullPackage that = (FullPackage) o;

        if (tpPrice != that.tpPrice) {
            return false;
        }
        if (tpName != null ? !tpName.equals(that.tpName) : that.tpName != null) {
            return false;
        }
        if (aName != null ? !aName.equals(that.aName) : that.aName != null) {
            return false;
        }
        if (aDescription != null ? !aDescription.equals(that.aDescription) : that.aDescription != null) {
            return false;
        }
        if (tDate != null ? !tDate.equals(that.tDate) : that.tDate != null) {
            return false;
        }
        if (tType != null ? !tType.equals(that.tType) : that.tType != null) {
            return false;
        }
        if (tDestination != null ? !tDestination.equals(that.tDestination) : that.tDestination != null) {
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
        int result = tpName != null ? tpName.hashCode() : 0;
        result = 31 * result + tpPrice;
        result = 31 * result + (aName != null ? aName.hashCode() : 0);
        result = 31 * result + (aDescription != null ? aDescription.hashCode() : 0);
        result = 31 * result + (tDate != null ? tDate.hashCode() : 0);
        result = 31 * result + (tType != null ? tType.hashCode() : 0);
        result = 31 * result + (tDestination != null ? tDestination.hashCode() : 0);
        result = 31 * result + (accName != null ? accName.hashCode() : 0);
        result = 31 * result + (accAddress != null ? accAddress.hashCode() : 0);
        return result;
    }
}
