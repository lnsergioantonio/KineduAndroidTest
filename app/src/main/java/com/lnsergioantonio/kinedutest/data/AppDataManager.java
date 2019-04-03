package com.lnsergioantonio.kinedutest.data;

import com.lnsergioantonio.kinedutest.BuildConfig;
import com.lnsergioantonio.kinedutest.data.api.IServiceListener;
import com.lnsergioantonio.kinedutest.data.api.KineduService;
import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.api.article.Article;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;
import com.lnsergioantonio.kinedutest.data.preferences.AppPreferences;
import com.lnsergioantonio.kinedutest.utils.AssetsPropertyReader;

import java.util.ArrayList;

public class AppDataManager implements DataManager, IServiceListener {
    private final AssetsPropertyReader propertyReader;
    private KineduService service;
    private DataManager.ActivitiesIntractor.onFinishListener activitiesIntractor;
    private DataManager.ArticlesIntractor.onFinishListener articlesIntractor;
    private DataManager.ArticleIntractor.onFinishListener articleIntractor;
    private AppPreferences preferences;

    public AppDataManager(AppPreferences appPreferences, AssetsPropertyReader assetsPropertyReader) {
        this.propertyReader = assetsPropertyReader;
        this.service = new KineduService(this,propertyReader);
        this.preferences = appPreferences;
    }

    @Override
    public void setActivitiesIntractor(ActivitiesIntractor.onFinishListener intractor) {
        this.activitiesIntractor = intractor;
    }

    @Override
    public void setArticlesIntractor(ArticlesIntractor.onFinishListener intractor) {
        this.articlesIntractor=intractor;
    }

    @Override
    public void setArticleDetailIntractor(ArticleIntractor.onFinishListener intractor) {
        this.articleIntractor=intractor;
    }

    @Override
    public void getArticles() {
        ArrayList<Articles> articlesArrayList = preferences.getArticles();
        if(articlesArrayList == null)
            service.getArticles();
        else
            articlesIntractor.onSuccess(articlesArrayList);
    }

    @Override
    public void getActivities() {
        ArrayList<Activities> activitiesArrayList = preferences.getActivities();
        if(activitiesArrayList == null)
            service.getActivities();
        else
            activitiesIntractor.onSuccess(activitiesArrayList);

    }

    @Override
    public void getArticle(int articleId) {
        service.getArticle(articleId);
    }


    @Override
    public void setListActivities(ArrayList<Activities> activitiesArrayList) {
        preferences.setActivities(activitiesArrayList);
    }

    @Override
    public void setListArticles(ArrayList<Articles> articlesArrayList) {
        preferences.setArticles(articlesArrayList);
    }

    @Override
    public ArrayList<Activities> getListActivities() {
        return preferences.getActivities();
    }

    @Override
    public ArrayList<Articles> getListArticles() {
        return preferences.getArticles();
    }

    @Override
    public void successGetActivities(ArrayList<Activities> activitiesArrayList) {
        activitiesIntractor.onSuccess(activitiesArrayList);
    }

    @Override
    public void error(String error) {
        if (activitiesIntractor!=null)
            activitiesIntractor.onError(error);
        else if (articlesIntractor!=null)
            articlesIntractor.onError(error);
        else if(articleIntractor!=null)
            articleIntractor.onError(error);
    }

    @Override
    public void successGetArticles(ArrayList<Articles> articlesArrayList) {
        articlesIntractor.onSuccess(articlesArrayList);
    }

    @Override
    public void successGetArticle(Article article) {
        articleIntractor.onSuccess(article);
    }
}
