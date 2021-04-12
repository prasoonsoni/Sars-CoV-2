package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class precautions extends AppCompatActivity {
    ImageView precautionsBackButton;
    ConstraintLayout precautionsLayout;
    ConstraintLayout topPrecautions;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back = new Intent(getApplicationContext(),home.class);
        startActivity(back);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions);
        precautionsLayout = findViewById(R.id.precautionsLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) precautionsLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        topPrecautions = findViewById(R.id.topOfLayouts);
        topPrecautions.animate().translationYBy(1000f).setDuration(300);
        precautionsBackButton = findViewById(R.id.locationBackButton);

        CardView crowdCardView = findViewById(R.id.crowdCardView);
        crowdCardView.animate().translationXBy(2000f).rotation(360).setDuration(1000);

        CardView handshakeCardView = findViewById(R.id.handshakeCardView);
        handshakeCardView.animate().translationXBy(2000f).rotation(360).setDuration(1300);

        CardView travellingCardView = findViewById(R.id.travellingCardView);
        travellingCardView.animate().translationXBy(2000f).rotation(360).setDuration(1600);
        //
        CardView maskCardView = findViewById(R.id.maskCardView);
        maskCardView.animate().translationXBy(-2000f).rotation(360).setDuration(1000);

        CardView homeCardView = findViewById(R.id.homeCardView);
        homeCardView.animate().translationXBy(-2000f).rotation(360).setDuration(1300);

        CardView sanitizerCardView = findViewById(R.id.sanitizerCardView);
        sanitizerCardView.animate().translationXBy(-2000f).rotation(360).setDuration(1600);






        precautionsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent precautionsToHome = new Intent(getApplicationContext(), home.class);
                startActivity(precautionsToHome);
            }
        });
    }
}