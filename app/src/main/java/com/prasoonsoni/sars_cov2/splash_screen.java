package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
    TextView save;
    TextView prasoon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        save = findViewById(R.id.save);
        prasoon = findViewById(R.id.prasoon);
        save.animate().translationYBy(1000f).setDuration(500);
        prasoon.animate().translationYBy(-1000f).setDuration(500);
        SharedPreferences getShared = getSharedPreferences("email",MODE_PRIVATE);
        String value = getShared.getString("email", "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (value==""){
                    Intent mainIntent = new Intent(splash_screen.this, MainActivity.class);
                    splash_screen.this.startActivity(mainIntent);
                    splash_screen.this.finish();
                } else {
                    Intent mainIntent = new Intent(splash_screen.this, home.class);
                    splash_screen.this.startActivity(mainIntent);
                    splash_screen.this.finish();
                }


            }
        },5000);


    }
}