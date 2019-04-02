package com.lnsergioantonio.kinedutest.ui.home.catalog.articles;

import android.content.Context;

import com.lnsergioantonio.kinedutest.data.AppDataManager;
import com.lnsergioantonio.kinedutest.data.DataManager;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;
import com.lnsergioantonio.kinedutest.data.preferences.AppPreferences;

import java.util.ArrayList;

public class ArticlesChildPresenter implements ArticlesChildMvp.Presenter, DataManager.ArticlesIntractor.onFinishListener {
    private ArticlesChildMvp.View view;
    private AppDataManager dataManager;

    public ArticlesChildPresenter(ArticlesChildMvp.View view, Context context) {
        this.view = view;
        this.dataManager = new AppDataManager(new AppPreferences(context));
        dataManager.setArticlesIntractor(this);
    }

    @Override
    public void requestArticles() {
        dataManager.getArticles(dataManager.getToken(),5,2064732);
    }

    @Override
    public ArrayList<Articles> getListArticles() {
        return null;
    }

    @Override
    public void onSuccess(ArrayList<Articles> articlesArrayList) {
        dataManager.setListArticles(articlesArrayList);
        view.hideLoading();
        view.setDataToRecyclerView(articlesArrayList);
    }

    @Override
    public void onError(String error) {
        view.hideLoading();
        view.showError(error);
    }
}
