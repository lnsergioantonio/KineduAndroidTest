package com.lnsergioantonio.kinedutest.data.api.article;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RelatedItems {
    @SerializedName("activities")
    final ArrayList<Activities> activities;
    @SerializedName("articles")
    final ArrayList<Articles> articles;

    public RelatedItems(ArrayList<Activities> activities, ArrayList<Articles> articles) {
        this.activities = activities;
        this.articles = articles;
    }

    public ArrayList<Activities> getActivities() {
        return activities;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }
}
