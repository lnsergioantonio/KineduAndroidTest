package com.lnsergioantonio.kinedutest.data.api;

import com.lnsergioantonio.kinedutest.data.api.activities.ActivitiesResponse;
import com.lnsergioantonio.kinedutest.data.api.article.DataResponse;
import com.lnsergioantonio.kinedutest.data.api.articles.ArticlesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IKineduService {
    @GET("catalogue/activities")
    Call<ActivitiesResponse> getActivities(@Header("Authorization") String authorization,
                                          @Query("skill_id") int skill_id,
                                          @Query("baby_id") int baby_id);
    @GET("catalogue/articles")
    Call<ArticlesResponse> getArticles(@Header("Authorization") String authorization,
                                       @Query("skill_id") int skill_id,
                                       @Query("baby_id") int baby_id);

    @GET("articles/{id}")
    Call<DataResponse> getArticle(@Header("Authorization") String authorization,
                                  @Path("id") int id);
}
