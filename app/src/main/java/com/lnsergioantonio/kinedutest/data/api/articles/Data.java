package com.lnsergioantonio.kinedutest.data.api.articles;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {
    @SerializedName("articles")
    final ArrayList<Articles> articles;

    public Data(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }
}
