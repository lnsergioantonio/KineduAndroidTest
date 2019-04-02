package com.lnsergioantonio.kinedutest.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.api.article.Article;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AppPreferences implements Preferences {
    private SharedPreferences preferences;
    private static final String KEY_ACTIVITIES_LIST = "KEY_ACTIVITIES_LIST";
    private static final String KEY_ARTICLES_LIST = "KEY_ARTICLES_LIST";

    public AppPreferences(Context context) {
        this.preferences = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    @Override
    public void setActivities(ArrayList<Activities> activitiesArrayList) {
        String jsonActivities = new Gson().toJson(activitiesArrayList);
        preferences.edit().putString(KEY_ACTIVITIES_LIST,jsonActivities).apply();
    }

    @Override
    public ArrayList<Activities> getActivities() {
        String jsonArray = preferences.getString(KEY_ACTIVITIES_LIST,null);
        ArrayList<Activities> activitiesArrayList = null;
        if(jsonArray!=null){
            Type activitiesListType = new TypeToken<ArrayList<Activities>>(){}.getType();

            activitiesArrayList = new Gson().fromJson(jsonArray,activitiesListType);
        }

        return activitiesArrayList;
    }

    @Override
    public void setArticles(ArrayList<Articles> articlesArrayList) {
        String jsonArticles = new Gson().toJson(articlesArrayList);
        preferences.edit().putString(KEY_ARTICLES_LIST,jsonArticles).apply();
    }

    @Override
    public ArrayList<Articles> getArticles() {
        String jsonArticles = preferences.getString(KEY_ARTICLES_LIST,null);
        ArrayList<Articles> articlesArrayList = null;
        if(jsonArticles!=null){
            Type articlesListType = new TypeToken<ArrayList<Articles>>(){}.getType();

            articlesArrayList = new Gson().fromJson(jsonArticles,articlesListType);
        }
        return articlesArrayList;
    }

    @Override
    public void setArticle(Article articleDetail) {

    }

    @Override
    public Article getArticle() {
        return null;
    }
}
