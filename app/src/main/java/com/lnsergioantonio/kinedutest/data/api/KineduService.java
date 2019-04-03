package com.lnsergioantonio.kinedutest.data.api;

import android.util.Log;

import com.lnsergioantonio.kinedutest.BuildConfig;
import com.lnsergioantonio.kinedutest.data.api.activities.ActivitiesResponse;
import com.lnsergioantonio.kinedutest.data.api.article.DataResponse;
import com.lnsergioantonio.kinedutest.data.api.articles.ArticlesResponse;
import com.lnsergioantonio.kinedutest.utils.AssetsPropertyReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KineduService {
    private static final String TAG = "KineduService";
    private IServiceListener listener;
    private IKineduService service;
    private String token;
    private int skillId,babyId;

    public KineduService(IServiceListener listener, AssetsPropertyReader assetsPropertyReader) {
        this.listener = listener;

        this.babyId = Integer.parseInt(assetsPropertyReader.getProperties(BuildConfig.FILE_NAME_PROPERTIES).getProperty(BuildConfig.BABY_ID));
        this.skillId = Integer.parseInt(assetsPropertyReader.getProperties(BuildConfig.FILE_NAME_PROPERTIES).getProperty(BuildConfig.SKILL_ID));
        this.token = assetsPropertyReader.getProperties(BuildConfig.FILE_NAME_PROPERTIES).getProperty(BuildConfig.TOKEN);

        this.service = new ApiClient().getClient(assetsPropertyReader).create(IKineduService.class);
    }

    public void getActivities(){
        Call<ActivitiesResponse> responseCall = service.getActivities(token,skillId,babyId);

        responseCall.enqueue(new Callback<ActivitiesResponse>() {
            @Override
            public void onResponse(Call<ActivitiesResponse> call, Response<ActivitiesResponse> response) {
                if(response.code()==200){
                    ActivitiesResponse activitiesResponse = response.body();
                    listener.successGetActivities(activitiesResponse.getData().getActivities());
                }else{
                    listener.error(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<ActivitiesResponse> call, Throwable t) {
                Log.d("KINEDUSERVICE",t.getMessage());
                listener.error(t.getMessage());
            }
        });
    }

    public void getArticles(){
        Call<ArticlesResponse> responseCall = service.getArticles(token,skillId,babyId);

        responseCall.enqueue(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(Call<ArticlesResponse> call, Response<ArticlesResponse> response) {
                if(response.code()==200){
                    ArticlesResponse articlesResponse = response.body();
                    listener.successGetArticles(articlesResponse.getData().getArticles());
                }else{
                    listener.error(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<ArticlesResponse> call, Throwable t) {
                Log.d("KINEDUSERVICE",t.getMessage());
                listener.error(t.getMessage());
            }
        });
    }

    public void getArticle(String token,int id){
        Call<DataResponse> responseCall = service.getArticle(token,id);

        responseCall.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.code()==200){
                    DataResponse dataResponse = response.body();
                    listener.successGetArticle(dataResponse.getData().getArticle());
                }else{
                    listener.error(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.d("KINEDUSERVICE",t.getMessage());
                listener.error(t.getMessage());
            }
        });
    }
}
