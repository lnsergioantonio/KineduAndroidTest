package com.lnsergioantonio.kinedutest.data.api.activities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {
    @SerializedName("id")
    final int id;
    @SerializedName("name")
    final String name;
    @SerializedName("type")
    final String type;
    @SerializedName("activities")
    final ArrayList<Activities> activities;

    public Data(int id, String name, String type, ArrayList<Activities> activities) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.activities = activities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Activities> getActivities() {
        return activities;
    }
}
