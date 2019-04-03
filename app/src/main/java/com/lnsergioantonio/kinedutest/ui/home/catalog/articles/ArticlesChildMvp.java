package com.lnsergioantonio.kinedutest.ui.home.catalog.articles;

import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;

import java.util.ArrayList;

public interface ArticlesChildMvp {
    interface View{
        void showLoading();
        void hideLoading();
        void showContent();
        void hideContent();
        void setDataToRecyclerView(ArrayList<Articles> articlesList);
        void showError(String error);
    }

    interface Presenter{
        void requestArticles();
    }
}
