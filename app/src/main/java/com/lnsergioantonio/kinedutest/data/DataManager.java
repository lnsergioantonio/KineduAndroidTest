package com.lnsergioantonio.kinedutest.data;

import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.api.article.Article;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;

import java.util.ArrayList;

public interface DataManager {
    void setActivitiesIntractor(ActivitiesIntractor.onFinishListener intractor);
    void setArticlesIntractor(ArticlesIntractor.onFinishListener intractor);
    void setArticleDetailIntractor(ArticleIntractor.onFinishListener intractor);

    void getArticles();
    void getActivities();
    void getArticle(int articleId);

    void setListActivities(ArrayList<Activities> activitiesArrayList);
    void setListArticles(ArrayList<Articles> articlesArrayList);
    ArrayList<Activities> getListActivities();
    ArrayList<Articles> getListArticles();

    interface ActivitiesIntractor{
        interface onFinishListener{
            void onSuccess(ArrayList<Activities> activitiesArrayList);
            void onError(String error);
        }
    }

    interface ArticlesIntractor{
        interface onFinishListener{
            void onSuccess(ArrayList<Articles> articlesArrayList);
            void onError(String error);
        }
    }

    interface ArticleIntractor{
        interface onFinishListener{
            void onSuccess(Article article);
            void onError(String error);
        }
    }
}
