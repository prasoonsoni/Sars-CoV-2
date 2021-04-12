package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class feedback extends AppCompatActivity {
    ConstraintLayout feedbackConstraintLayout;
    ConstraintLayout topSymptoms;
    ImageView feedbackBackButton;
    EditText yourNameEditText;
    EditText yourEmailEditText;
    EditText yourMessageEditText;
    Button sendFeedback;
    TextView sendMessageTextView;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back = new Intent(getApplicationContext(),home.class);
        startActivity(back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedbackConstraintLayout = findViewById(R.id.feedbackConstraintLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) feedbackConstraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        sendMessageTextView = findViewById(R.id.sendMessageTextView);
        //////////////////////////////////////////
        yourNameEditText = findViewById(R.id.yourNameEditText);
        yourNameEditText.animate().translationXBy(2000f).setDuration(1000);

        yourEmailEditText = findViewById(R.id.yourEmailEditText);
        yourEmailEditText.animate().translationXBy(2000f).setDuration(1200);

        yourMessageEditText = findViewById(R.id.yourMessageEditText);
        yourMessageEditText.animate().translationXBy(2000f).setDuration(1400);

        sendFeedback = findViewById(R.id.sendFeedback);
        sendFeedback.animate().translationXBy(2000f).setDuration(1600);
        sendMessageTextView.animate().alpha(1f).setDuration(1000);

        //////////////////////////////////////////
        topSymptoms = findViewById(R.id.topOfLayouts);
        topSymptoms.animate().translationYBy(1000f).setDuration(300);
        feedbackBackButton = findViewById(R.id.locationBackButton);
        SharedPreferences getShared = getSharedPreferences("email",MODE_PRIVATE);
        String value = getShared.getString("email", "");
        yourEmailEditText.setText(value);
        feedbackBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedbackToHome = new Intent(getApplicationContext(), home.class);
                startActivity(feedbackToHome);
            }
        });
        sendFeedback = findViewById(R.id.sendFeedback);
        sendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameOfSender = yourNameEditText.getText().toString();
                String emailOfSender = yourEmailEditText.getText().toString();
                String messageOfSender = yourMessageEditText.getText().toString();
                if(nameOfSender.isEmpty() || emailOfSender.isEmpty() || messageOfSender.isEmpty()){
                    Toast.makeText(feedback.this, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("name", nameOfSender);
                    map.put("email", emailOfSender);
                    map.put("message", messageOfSender);
                    FirebaseDatabase.getInstance().getReference().child("Feedback").child(nameOfSender).updateChildren(map);
                    Toast.makeText(feedback.this, "Thank You for feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}