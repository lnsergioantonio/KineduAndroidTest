package com.lnsergioantonio.kinedutest.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lnsergioantonio.kinedutest.R;
import com.lnsergioantonio.kinedutest.ui.home.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
