package com.lnsergioantonio.kinedutest.data.api.articles;

import com.google.gson.annotations.SerializedName;

public class Articles {
    @SerializedName("type")
    final String type;
    @SerializedName("id")
    final int id;
    @SerializedName("name")
    final String name;
    @SerializedName("min_age")
    final int min_age;
    @SerializedName("max_age")
    final int max_age;
    @SerializedName("picture")
    final String picture;
    @SerializedName("area_id")
    final int area_id;
    @SerializedName("short_description")
    final String short_description;

    public Articles(String type, int id, String name, int min_age, int max_age, String picture, int area_id, String short_description) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.min_age = min_age;
        this.max_age = max_age;
        this.picture = picture;
        this.area_id = area_id;
        this.short_description = short_description;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMin_age() {
        return min_age;
    }

    public int getMax_age() {
        return max_age;
    }

    public String getPicture() {
        return picture;
    }

    public int getArea_id() {
        return area_id;
    }

    public String getShort_description() {
        return short_description;
    }
}
