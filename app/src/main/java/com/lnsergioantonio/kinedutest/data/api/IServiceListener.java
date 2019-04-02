package com.lnsergioantonio.kinedutest.data.api;

import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.api.article.Article;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;

import java.util.ArrayList;

public interface IServiceListener {
    void successGetActivities(ArrayList<Activities> activitiesArrayList);
    void error(String error);
    void successGetArticles(ArrayList<Articles> articlesArrayList);
    void successGetArticle(Article article);
}
