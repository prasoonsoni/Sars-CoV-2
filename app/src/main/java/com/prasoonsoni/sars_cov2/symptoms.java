package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class symptoms extends AppCompatActivity {
    ConstraintLayout symptomsConstraintLayout;
    ImageView symptomsBackButton;
    ConstraintLayout topSymptoms;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back = new Intent(getApplicationContext(),home.class);
        startActivity(back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        symptomsConstraintLayout = findViewById(R.id.symptomsConstraintLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) symptomsConstraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        symptomsBackButton = findViewById(R.id.locationBackButton);
        topSymptoms = findViewById(R.id.topOfLayouts);
        topSymptoms.animate().translationYBy(1000f).setDuration(300);
        CardView headacheCardView = findViewById(R.id.headacheCardView);
        headacheCardView.animate().translationXBy(2000f).rotation(360).setDuration(1000);

        CardView coughCardView = findViewById(R.id.coughCardView);
        coughCardView.animate().translationXBy(2000f).rotation(360).setDuration(1300);

        CardView noseCardView = findViewById(R.id.noseCardView);
        noseCardView.animate().translationXBy(2000f).rotation(360).setDuration(1600);
        //
        CardView vomitingCardView = findViewById(R.id.vomitingCardView);
        vomitingCardView.animate().translationXBy(-2000f).rotation(360).setDuration(1000);

        CardView feverCardView = findViewById(R.id.feverCardView);
        feverCardView.animate().translationXBy(-2000f).rotation(360).setDuration(1300);

        CardView throatCardView = findViewById(R.id.throatCardView);
        throatCardView.animate().translationXBy(-2000f).rotation(360).setDuration(1600);

        symptomsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent precautionsToHome = new Intent(getApplicationContext(), home.class);
                startActivity(precautionsToHome);
            }
        });
    }
}