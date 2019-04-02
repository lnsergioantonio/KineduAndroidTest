package com.lnsergioantonio.kinedutest.data.api.activities;

import com.google.gson.annotations.SerializedName;

public class Activities {
    @SerializedName("id")
    final int id;
    @SerializedName("name")
    final String name;
    @SerializedName("age")
    final int age;
    @SerializedName("age_group")
    final String age_group;
    @SerializedName("activity_type")
    final String activity_type;
    @SerializedName("is_holiday")
    final boolean is_holiday;
    @SerializedName("domain_id")
    final int domain_id;
    @SerializedName("area_id")
    final int area_id;
    @SerializedName("purpose")
    final String purpose;
    @SerializedName("thumbnail")
    final String thumbnail;
    @SerializedName("active_milestones")
    final int active_milestones;
    @SerializedName("completed_milestones")
    final int completed_milestones;

    public Activities(int id, String name, int age, String age_group, String activity_type, boolean is_holiday, int domain_id, int area_id, String purpose, String thumbnail, int active_milestones, int completed_milestones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.age_group = age_group;
        this.activity_type = activity_type;
        this.is_holiday = is_holiday;
        this.domain_id = domain_id;
        this.area_id = area_id;
        this.purpose = purpose;
        this.thumbnail = thumbnail;
        this.active_milestones = active_milestones;
        this.completed_milestones = completed_milestones;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAge_group() {
        return age_group;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public boolean isIs_holiday() {
        return is_holiday;
    }

    public int getDomain_id() {
        return domain_id;
    }

    public int getArea_id() {
        return area_id;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getActive_milestones() {
        return active_milestones;
    }

    public int getCompleted_milestones() {
        return completed_milestones;
    }
}
