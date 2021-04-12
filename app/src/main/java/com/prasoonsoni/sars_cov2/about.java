package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class about extends AppCompatActivity {
    ConstraintLayout aboutLayout, topAboutLayout;
    ImageView aboutBackButton;
    ImageView linkedin, github, instagram, whatsapp, facebook, google, twitter, snapchat, youtube, telegram;
    TextView prasoonSoni, appDeveloper, about, aboutDesc, socialIcons;
    CardView admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutLayout = findViewById(R.id.aboutConstraintLayout);
        aboutBackButton = findViewById(R.id.locationBackButton);
        topAboutLayout = findViewById(R.id.topOfLayouts);
        topAboutLayout.animate().translationYBy(1000f).setDuration(300);
        AnimationDrawable animationDrawable = (AnimationDrawable) aboutLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        linkedin = findViewById(R.id.linkedin);
        github = findViewById(R.id.github);
        instagram = findViewById(R.id.instagram);
        whatsapp = findViewById(R.id.whatsapp);
        facebook = findViewById(R.id.facebook);
        google = findViewById(R.id.google);
        twitter = findViewById(R.id.twitter);
        snapchat = findViewById(R.id.snapchat);
        youtube = findViewById(R.id.youtube);
        telegram = findViewById(R.id.telegram);
        admin = findViewById(R.id.admin);
        prasoonSoni = findViewById(R.id.prasoonSoni);
        appDeveloper = findViewById(R.id.appDeveloper);
        about = findViewById(R.id.about);
        aboutDesc = findViewById(R.id.aboutDesc);
        socialIcons = findViewById(R.id.socialIcons);
        socialIcons.animate().alpha(1f).setDuration(1300);
        about.animate().alpha(1f).translationXBy(2000f).setDuration(1200);
        aboutDesc.animate().alpha(1f).translationXBy(2000f).setDuration(1400);
        prasoonSoni.animate().translationXBy(-2000f).setDuration(900);
        appDeveloper.animate().translationXBy(-2000f).setDuration(1400);
        admin.animate().translationXBy(2000f).setDuration(1200);
        aboutBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backButton = new Intent(getApplicationContext(), home.class);
                startActivity(backButton);
            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://www.linkedin.com/in/prasoonsoni";
                Intent linkedIn = new Intent(Intent.ACTION_VIEW);
                linkedIn.setData(Uri.parse(link));
                startActivity(linkedIn);
            }
        });
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://github.com/PrasoonSoni";
                Intent github = new Intent(Intent.ACTION_VIEW);
                github.setData(Uri.parse(link));
                startActivity(github);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://instagram.com/prasoonsoni";
                Intent instagram = new Intent(Intent.ACTION_VIEW);
                instagram.setData(Uri.parse(link));
                startActivity(instagram);
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://api.whatsapp.com/send?phone=919414547509";
                Intent whatsapp = new Intent(Intent.ACTION_VIEW);
                whatsapp.setData(Uri.parse(link));
                startActivity(whatsapp);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://twitter.com/prasoonsoni_";
                Intent twitter = new Intent(Intent.ACTION_VIEW);
                twitter.setData(Uri.parse(link));
                startActivity(twitter);
            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://t.me/prasoonsoni";
                Intent telegram = new Intent(Intent.ACTION_VIEW);
                telegram.setData(Uri.parse(link));
                startActivity(telegram);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://youtube.com/channel/UC8OdQ8y3TNwA9Qd5UEc8T4g";
                Intent youtube = new Intent(Intent.ACTION_VIEW);
                youtube.setData(Uri.parse(link));
                startActivity(youtube);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://facebook.com/theprasoonsoni";
                Intent facebook = new Intent(Intent.ACTION_VIEW);
                facebook.setData(Uri.parse(link));
                startActivity(facebook);
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(about.this, "Mail me : prasoonsoni03@gmail.com", Toast.LENGTH_SHORT).show();

            }
        });
        snapchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://snapchat.com/prasoonsoni";
                Intent snapchat = new Intent(Intent.ACTION_VIEW);
                snapchat.setData(Uri.parse(link));
                startActivity(snapchat);
            }
        });
        twitter.animate().translationXBy(2000f).setDuration(800);
        whatsapp.animate().translationXBy(2000f).setDuration(900);
        instagram.animate().translationXBy(2000f).setDuration(1000);
        github.animate().translationXBy(2000f).setDuration(1100);
        linkedin.animate().translationXBy(2000f).setDuration(1200);

        telegram.animate().translationXBy(-2000f).setDuration(800);
        youtube.animate().translationXBy(-2000f).setDuration(900);
        facebook.animate().translationXBy(-2000f).setDuration(1000);
        google.animate().translationXBy(-2000f).setDuration(1100);
        snapchat.animate().translationXBy(-2000f).setDuration(1200);
    }
}