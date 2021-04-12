package com.prasoonsoni.sars_cov2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_signup extends AppCompatActivity {
    ConstraintLayout loginSignup;
    Switch loginSignupSwitch;
    TextView signinTextView;
    TextView signupTextView;
    Button signinButton;
    Button signupButton;
    ConstraintLayout loginSignupLayout;
    private FirebaseAuth mAuth;
    EditText email;
    EditText password;
    TextView welcome;
    ImageView userPersonMale;
    ImageView userPersonFemale;
    TextView missYou;

    public void maleTapped(View view){
        userPersonMale.animate().alpha(0f).setDuration(500);
        userPersonFemale.animate().alpha(1f).setDuration(500);
        userPersonMale.setClickable(false);
        userPersonFemale.setClickable(true);

    }
    public void femaleTapped(View view){
        userPersonMale.animate().alpha(1f).setDuration(500);
        userPersonFemale.animate().alpha(0f).setDuration(500);
        userPersonMale.setClickable(true);
        userPersonFemale.setClickable(false);
    }




    public void createAccount(View view) {
        if (email.getText().toString() != "" && password.getText().toString() != "") {
            try {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(login_signup.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.i("failure:", task.getException().toString());
                                    Toast.makeText(login_signup.this, "Authentication failed: " + task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } catch(Exception e) {
                Toast.makeText(this, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
        }

    }

    public void loginAccount(View view) {
        if (email.getText().toString() != "" && password.getText().toString() != "") {
            try {
                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("signInWithEmail:", "success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(login_signup.this, "Login successfully", Toast.LENGTH_SHORT).show();

                                    String emailOfUser = email.getText().toString();
                                    SharedPreferences sharedPreferences = getSharedPreferences("email",MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("email", emailOfUser);
                                    editor.apply();


                                    Intent home = new Intent(getApplicationContext(), home.class);
                                    startActivity(home);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.i("signInWithEmail:failure", task.getException().toString());
                                    Toast.makeText(login_signup.this, "Login failed: " + task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } catch (Exception e){
                Toast.makeText(this, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        loginSignup = findViewById(R.id.loginSignup);
        AnimationDrawable animationDrawable = (AnimationDrawable) loginSignup.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        missYou = findViewById(R.id.missYou);
        welcome = findViewById(R.id.welcome);
        userPersonMale = findViewById(R.id.userPersonMale);
        userPersonFemale = findViewById(R.id.userPersonFemale);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        loginSignupSwitch = findViewById(R.id.loginSignupSwitch);
        signinTextView = findViewById(R.id.signinTextView);
        signupTextView = findViewById(R.id.signupTextView);
        signinButton = findViewById(R.id.signinButton);
        signupButton = findViewById(R.id.signupButton);
        loginSignupLayout = findViewById(R.id.loginSignupLayout);
        loginSignupLayout.animate().translationYBy(-2000f).setDuration(1500);
        userPersonMale.animate().alpha(1f).setDuration(1000);
        userPersonMale.setClickable(true);
        userPersonFemale.setClickable(false);
        welcome.animate().translationXBy(2000f).setDuration(1000);
        missYou.animate().translationXBy(2000f).setDuration(1200);


        loginSignupSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginSignupSwitch.isChecked()) {
                    signupTextView.setTextColor(Color.parseColor("#0B393C"));
                    signinTextView.setTextColor(Color.parseColor("#f24789"));
                    signupButton.animate().translationXBy(-2000f).setDuration(700);
                    signinButton.animate().translationXBy(-2000f).setDuration(700);
                } else {
                    signinTextView.setTextColor(Color.parseColor("#0B393C"));
                    signupTextView.setTextColor(Color.parseColor("#f24789"));
                    signupButton.animate().translationXBy(2000f).setDuration(700);
                    signinButton.animate().translationXBy(2000f).setDuration(700);
                }
            }
        });


    }
}