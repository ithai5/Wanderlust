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

    @Id
    @Column(name = "activity_id")
    public int getActivityId ()
    {
        return activityId;
    }

    public void setActivityId (int activityId)
    {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "a_name")
    public String getaName ()
    {
        return aName;
    }

    public void setaName (String aName)
    {
        this.aName = aName;
    }

    @Basic
    @Column(name = "a_description")
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
}
