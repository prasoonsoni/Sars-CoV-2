package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class quiz extends AppCompatActivity {
    ConstraintLayout quizConstraintLayout, question1, question2, question3, question4, question5, topQuiz;
    ImageView quizToHome;
    Button q1o1, q1o2, q1o3, q2o1, q2o2, q2o3, q3o1, q3o2, q3o3, q4o1, q4o2, q4o3, q5o1, q5o2, q5o3, clickHere;
    TextView choose, knowMore;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back = new Intent(getApplicationContext(),home.class);
        startActivity(back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizConstraintLayout = findViewById(R.id.quizConstraintLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) quizConstraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        quizToHome = findViewById(R.id.locationBackButton);
        topQuiz = findViewById(R.id.topOfLayouts);
        topQuiz.animate().translationYBy(1000f).setDuration(300);
        knowMore = findViewById(R.id.knowMore);
        clickHere = findViewById(R.id.clickHere);
        clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://who.int/emergencies/diseases/novel-coronavirus-2019";
                Intent openBrowser = new Intent(Intent.ACTION_VIEW);
                openBrowser.setData(Uri.parse(url));
                startActivity(openBrowser);
            }
        });

        quizToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qToHome = new Intent(getApplicationContext(), home.class);
                startActivity(qToHome);
            }
        });
        choose = findViewById(R.id.choose);

        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        question3 = findViewById(R.id.question3);
        question4 = findViewById(R.id.question4);
        question5 = findViewById(R.id.question5);

        q1o1 = findViewById(R.id.q1o1);
        q1o2 = findViewById(R.id.q1o2);
        q1o3 = findViewById(R.id.q1o3);

        q2o1 = findViewById(R.id.q2o1);
        q2o2 = findViewById(R.id.q2o2);
        q2o3 = findViewById(R.id.q2o3);

        q3o1 = findViewById(R.id.q3o1);
        q3o2 = findViewById(R.id.q3o2);
        q3o3 = findViewById(R.id.q3o3);

        q4o1 = findViewById(R.id.q4o1);
        q4o2 = findViewById(R.id.q4o2);
        q4o3 = findViewById(R.id.q4o3);

        q5o1 = findViewById(R.id.q5o1);
        q5o2 = findViewById(R.id.q5o2);
        q5o3 = findViewById(R.id.q5o3);
/////////////////////////////
        question1.animate().translationXBy(-2000f).setDuration(500);
   ////////////////////////////111111111111111
        q1o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.correct_answer);
                question1.animate().translationXBy(-2000f).setDuration(500);
                question2.animate().translationXBy(-2000f).setDuration(500);
            }
        });

        q1o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

        q1o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

///////////////////////////22222222222222222
        q2o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

        q2o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.correct_answer);
                question2.animate().translationXBy(-2000f).setDuration(500);
                question3.animate().translationXBy(-2000f).setDuration(500);
            }
        });

        q2o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

//////////////////////////33333333333333333333333
        q3o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

        q3o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

        q3o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.correct_answer);
                question3.animate().translationXBy(-2000f).setDuration(500);
                question4.animate().translationXBy(-2000f).setDuration(500);
            }
        });

////////////////////////////////////44444444444444444444
        q4o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.correct_answer);
                question4.animate().translationXBy(-2000f).setDuration(500);
                question5.animate().translationXBy(-2000f).setDuration(500);
            }
        });

        q4o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

        q4o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

//////////////////////////////////////////555555555555555
        q5o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });

        q5o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.correct_answer);
                question5.animate().translationXBy(-2000f).setDuration(500);
                choose.setVisibility(View.INVISIBLE);
                knowMore.animate().translationXBy(-2000f).setDuration(500);
                clickHere.animate().translationXBy(-2000f).setDuration(600);
            }
        });

        q5o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.call_button);
            }
        });
    }
}