package com.lnsergioantonio.kinedutest.ui.article;

import android.content.Context;

import com.lnsergioantonio.kinedutest.data.AppDataManager;
import com.lnsergioantonio.kinedutest.data.DataManager;
import com.lnsergioantonio.kinedutest.data.api.article.Article;
import com.lnsergioantonio.kinedutest.data.preferences.AppPreferences;
import com.lnsergioantonio.kinedutest.utils.AssetsPropertyReader;

public class ArticlePresenter implements ArticleMvp.Presenter, DataManager.ArticleIntractor.onFinishListener {
    private ArticleMvp.View view;
    private AppDataManager dataManager;
    public ArticlePresenter(ArticleMvp.View view,Context context) {
        this.view = view;
        this.dataManager = new AppDataManager(new AppPreferences(context),new AssetsPropertyReader(context));
        dataManager.setArticleDetailIntractor(this);
    }

    @Override
    public void getArticle(int articleId) {
        view.hideArticleDetail();
        view.showProgressbar();
        dataManager.getArticle(articleId);
    }

    @Override
    public void onSuccess(Article article) {
        view.setPicture(article.getPicture());
        view.setTitle(article.getTitle());
        view.setBody(article.getBody());
        view.hideProgresbar();
        view.showArticleDetail();
    }

    @Override
    public void onError(String error) {
        view.hideProgresbar();
        view.error(error);
    }
}
