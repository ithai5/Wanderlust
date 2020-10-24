package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Activity {
    private int activityId;
    private String aName;
    private String aDescription;
    private int travelPackageId;

    @Id
    @Column(name = "activity_id", nullable = false)
    public int getActivityId ()
    {
        return activityId;
    }

    public void setActivityId (int activityId)
    {
        this.activityId = activityId;
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
    @Column(name = "travel_package_id", nullable = false)
    public int getTravelPackageId ()
    {
        return travelPackageId;
    }

    public void setTravelPackageId (int travelPackageId)
    {
        this.travelPackageId = travelPackageId;
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

        Activity activity = (Activity) o;

        if (activityId != activity.activityId) {
            return false;
        }
        if (travelPackageId != activity.travelPackageId) {
            return false;
        }
        if (aName != null ? !aName.equals(activity.aName) : activity.aName != null) {
            return false;
        }
        if (aDescription != null ? !aDescription.equals(activity.aDescription) : activity.aDescription != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = activityId;
        result = 31 * result + (aName != null ? aName.hashCode() : 0);
        result = 31 * result + (aDescription != null ? aDescription.hashCode() : 0);
        result = 31 * result + travelPackageId;
        return result;
    }
}
