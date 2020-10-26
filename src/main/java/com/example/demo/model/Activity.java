package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Activity {
    private int activityId;
    private String aName;
    private String aDescription;
    private TravelPackage travelPackageByTravelPackageId;

    public Activity ()
    {
    }

    public Activity (int activityId, String aName, String aDescription, TravelPackage travelPackageByTravelPackageId)
    {
        this.activityId = activityId;
        this.aName = aName;
        this.aDescription = aDescription;
        this.travelPackageByTravelPackageId = travelPackageByTravelPackageId;
    }

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
