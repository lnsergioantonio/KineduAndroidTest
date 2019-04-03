package com.lnsergioantonio.kinedutest.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AssetsPropertyReader {
    private String TAG = "AssetsPropertyReader";
    private Context context;
    private Properties properties;

    public AssetsPropertyReader(Context context) {
        this.context = context;
        properties = new Properties();
    }

    public Properties getProperties(String fileName){
        AssetManager assetManager = context.getAssets();

        try {
            InputStream inputStream = assetManager.open(fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            Log.d(TAG, e.toString());
        }

        return properties;
    }
}
