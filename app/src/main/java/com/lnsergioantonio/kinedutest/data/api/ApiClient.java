package com.lnsergioantonio.kinedutest.data.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Retrofit retrofit = null;

    public Retrofit getClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30,TimeUnit.SECONDS);
        httpClient.writeTimeout(30,TimeUnit.SECONDS);

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://staging.kinedu.com/api/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

}
