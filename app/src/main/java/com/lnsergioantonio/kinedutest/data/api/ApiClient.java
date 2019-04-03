package com.lnsergioantonio.kinedutest.data.api;

import android.os.Build;

import com.lnsergioantonio.kinedutest.BuildConfig;
import com.lnsergioantonio.kinedutest.utils.AssetsPropertyReader;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Retrofit retrofit = null;

    public Retrofit getClient(AssetsPropertyReader assetsPropertyReader){
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
                    .baseUrl(assetsPropertyReader.getProperties(BuildConfig.FILE_NAME_PROPERTIES).getProperty(BuildConfig.BASE_URL))
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

}
