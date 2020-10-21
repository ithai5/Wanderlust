package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Activity {
    @Id
    @Column(name = "activity_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int activityId;

    @Basic
    @Column(name = "a_name")
    private String aName;

    @Basic
    @Column(name = "a_description")
    private String aDescription;


    public int getActivityId ()
    {
        return activityId;
    }

    public void setActivityId (int activityId)
    {
        this.activityId = activityId;
    }


    public String getaName ()
    {
        return aName;
    }

    public void setaName (String aName)
    {
        this.aName = aName;
    }


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
