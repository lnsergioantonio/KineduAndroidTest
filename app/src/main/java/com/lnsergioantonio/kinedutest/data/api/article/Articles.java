package com.lnsergioantonio.kinedutest.data.api.article;

import com.google.gson.annotations.SerializedName;

public class Articles {
    @SerializedName("id")
    final int id;
    @SerializedName("title")
    final String title;
    @SerializedName("picture")
    final String picture;
    @SerializedName("link")
    final String link;
    @SerializedName("area_id")
    final int area_id;
    @SerializedName("short_description")
    final String short_description;
    @SerializedName("faved")
    final boolean faved;

    public Articles(int id, String title, String picture, String link, int area_id, String short_description, boolean faved) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.link = link;
        this.area_id = area_id;
        this.short_description = short_description;
        this.faved = faved;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }

    public String getLink() {
        return link;
    }

    public int getArea_id() {
        return area_id;
    }

    public String getShort_description() {
        return short_description;
    }

    public boolean isFaved() {
        return faved;
    }
}
