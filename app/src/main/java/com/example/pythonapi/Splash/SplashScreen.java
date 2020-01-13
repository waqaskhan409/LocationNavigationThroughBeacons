package com.example.pythonapi.Splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pythonapi.FirstScreen;
import com.example.pythonapi.R;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(), FirstScreen.class);
                    startActivity(intent);
                    finish();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();

    }



}
