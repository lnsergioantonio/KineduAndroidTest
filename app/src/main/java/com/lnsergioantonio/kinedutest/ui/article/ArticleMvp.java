package com.lnsergioantonio.kinedutest.ui.article;

public interface ArticleMvp {
    interface View{
        void setPicture(String picture);
        void setTitle(String title);
        void setBody(String body);
        void error(String error);
        void showProgressbar();
        void hideProgresbar();
        void hideArticleDetail();
        void showArticleDetail();
    }
    interface Presenter{
        void getArticle(int articleId);
    }
}
