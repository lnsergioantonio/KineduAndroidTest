package com.lnsergioantonio.kinedutest.ui.home.catalog.articles;

import android.content.Context;

import com.lnsergioantonio.kinedutest.BuildConfig;
import com.lnsergioantonio.kinedutest.data.AppDataManager;
import com.lnsergioantonio.kinedutest.data.DataManager;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;
import com.lnsergioantonio.kinedutest.data.preferences.AppPreferences;
import com.lnsergioantonio.kinedutest.utils.AssetsPropertyReader;

import java.util.ArrayList;

public class ArticlesChildPresenter implements ArticlesChildMvp.Presenter, DataManager.ArticlesIntractor.onFinishListener {
    private ArticlesChildMvp.View view;
    private AppDataManager dataManager;
    private AssetsPropertyReader propertyReader;
    public ArticlesChildPresenter(ArticlesChildMvp.View view, Context context) {
        this.view = view;
        this.propertyReader = new AssetsPropertyReader(context);
        this.dataManager = new AppDataManager(new AppPreferences(context),propertyReader);
        dataManager.setArticlesIntractor(this);
    }

    @Override
    public void requestArticles() {
        view.showLoading();
        view.hideContent();
        dataManager.getArticles();
    }

    @Override
    public void onSuccess(ArrayList<Articles> articlesArrayList) {
        dataManager.setListArticles(articlesArrayList);
        view.setDataToRecyclerView(articlesArrayList);
        view.hideLoading();
        view.showContent();
    }

    @Override
    public void onError(String error) {
        view.hideLoading();
        view.showError(error);
    }
}
