package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout getStarted;
    TextView sarsCov2;
    TextView description;
    ImageView coronaLogo;
    Button getStartedButton;
    public void toStartLoginActivity(View view){
        Intent loginSignup = new Intent(getApplicationContext(),login_signup.class);
        startActivity(loginSignup);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStarted = findViewById(R.id.getStarted);
        AnimationDrawable animationDrawable = (AnimationDrawable) getStarted.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        sarsCov2 = findViewById(R.id.sarsCov2);
        description = findViewById(R.id.description);
        coronaLogo = findViewById(R.id.coronaLogo);
        getStartedButton = findViewById(R.id.getStartedButton);
        coronaLogo.animate().alpha(1f).setDuration(2000);
        sarsCov2.animate().translationXBy(2000f).setDuration(2300);
        description.animate().translationXBy(2000f).setDuration(2600);
        getStartedButton.animate().translationXBy(2000f).setDuration(2900);



    }
}