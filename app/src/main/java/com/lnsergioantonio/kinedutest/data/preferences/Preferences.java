package com.lnsergioantonio.kinedutest.data.preferences;

import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.api.article.Article;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;

import java.util.ArrayList;

public interface Preferences {
    void setActivities(ArrayList<Activities> activitiesArrayList);
    ArrayList<Activities> getActivities();

    void setArticles(ArrayList<Articles> articlesArrayList);
    ArrayList<Articles> getArticles();

    void setArticle(Article articleDetail);
    Article getArticle();
}
