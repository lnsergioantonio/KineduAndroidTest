package com.lnsergioantonio.kinedutest.data.api.article;

import com.google.gson.annotations.SerializedName;

public class Article {
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
    @SerializedName("body")
    final String body;

    public Article(int id, String title, String picture, String link, int area_id, String body) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.link = link;
        this.area_id = area_id;
        this.body = body;
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

    public String getBody() {
        return body;
    }
}
