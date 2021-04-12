package com.prasoonsoni.sars_cov2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    ConstraintLayout homeConstraintLayout, loadingLayout, mainLayout;
    private TextView covid19, feelingSick, sickInfo;
    private Button callNow, sendSms;
    CardView quizCardView, donateCardView, worldwidecardView, stateListActivity, yourLocationCardView;
    private TextView homeConfirmed, homeRecovered, homeDeaths, homeActive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeConstraintLayout = findViewById(R.id.homeConstraintLayout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fetchData();
            }
        },2000);
        yourLocationCardView = findViewById(R.id.yourLocation);
        AnimationDrawable animationDrawable = (AnimationDrawable) homeConstraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        quizCardView = findViewById(R.id.quizCardView);
        donateCardView = findViewById(R.id.donateCardView);
        worldwidecardView = findViewById(R.id.worldwideCardView);
        homeConfirmed = findViewById(R.id.stateConfirmed);
        homeRecovered = findViewById(R.id.stateRecovered);
        homeDeaths = findViewById(R.id.stateDeath);
        homeActive = findViewById(R.id.stateActive);
        stateListActivity = findViewById(R.id.stateListActivity);

        stateListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent state = new Intent(getApplicationContext(), statelist.class);
                startActivity(state);
            }
        });

        loadingLayout = findViewById(R.id.loadingLayout);
        mainLayout = findViewById(R.id.mainLayout);
        worldwidecardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent worldwideActivity = new Intent(getApplicationContext(), worldwide_cases.class);
                startActivity(worldwideActivity);
            }
        });

        ////////////api calling///////////
        homeConfirmed.setText("");
        homeRecovered.setText("");
        homeDeaths.setText("");
        homeActive.setText("");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fetchData();
            }
        },2000);






        quizCardView.animate().translationXBy(2000f).setDuration(1000);
        donateCardView.animate().translationXBy(-2000f).setDuration(1000);
        stateListActivity.animate().translationXBy(2000f).setDuration(1200);
        yourLocationCardView.animate().translationXBy(-2000f).setDuration(1200);
        worldwidecardView.animate().alpha(1f).setDuration(1500);
        quizCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quizActivity = new Intent(getApplicationContext(),quiz.class);
                startActivity(quizActivity);
            }
        });






        drawerLayout = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Your Pandemic Assistant");
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_draw_open,R.string.navigation_draw_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        covid19 = findViewById(R.id.covid19);
        covid19.animate().translationXBy(2000f).setDuration(1000);
        feelingSick = findViewById(R.id.feelingSick);
        feelingSick.animate().translationXBy(2000f).setDuration(1100);
        sickInfo = findViewById(R.id.sickInfo);
        sickInfo.animate().translationXBy(2000f).setDuration(1200);
        callNow = findViewById(R.id.callNow);
        callNow.animate().translationXBy(2000f).setDuration(1200);
        sendSms = findViewById(R.id.sendSms);
        sendSms.animate().translationXBy(-2000f).setDuration(1200);
        callNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:+91-11-23978046"));
                startActivity(call);


            }
        });
        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String whatsapp = "https://api.whatsapp.com/send?phone=918800007722";
                Intent sms = new Intent(Intent.ACTION_VIEW);
                sms.setData(Uri.parse(whatsapp));
                startActivity(sms);

            }
        });

        yourLocationCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locationActivity = new Intent(getApplicationContext(), location.class);
                startActivity(locationActivity);
            }
        });

        donateCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bankingActivity = new Intent(getApplicationContext(), banking.class);
                startActivity(bankingActivity);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeActivity:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();

                break;
            case R.id.searchCountryActivity:
                Intent searchCountry = new Intent(getApplicationContext(), country_cases.class);
                startActivity(searchCountry);

                break;
            case R.id.precautionsActivity:
                Intent precautions = new Intent(getApplicationContext(), precautions.class);
                startActivity(precautions);

                break;
            case R.id.symptomsActivity:
                Intent symptoms = new Intent(getApplicationContext(), symptoms.class);
                startActivity(symptoms);

                break;
            case R.id.feedbackActivity:
                Intent feedback = new Intent(getApplicationContext(), feedback.class);
                startActivity(feedback);

                break;
            case R.id.aboutusActivity:
                Intent about = new Intent(getApplicationContext(), about.class);
                startActivity(about);

                break;
            case R.id.toLogout:
                SharedPreferences sharedPreferences = getSharedPreferences("email",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", "");
                editor.apply();
                Toast.makeText(this, "Successfully Logged Out", Toast.LENGTH_SHORT).show();
                Intent loginSignup = new Intent(getApplicationContext(), login_signup.class);
                startActivity(loginSignup);

                break;

        }
        return true;
    }
    public void fetchData(){

        String url = "https://disease.sh/v2/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject response = new JSONObject(s);
                    homeConfirmed.setText(response.getString("cases"));
                    homeRecovered.setText(response.getString("recovered"));
                    homeDeaths.setText(response.getString("deaths"));
                    homeActive.setText(response.getString("active"));
                    Log.i("confirmed", response.getString("cases"));

                    loadingLayout.setVisibility(View.INVISIBLE);
                    mainLayout.setVisibility(View.VISIBLE);

                } catch (JSONException e) {
                    e.printStackTrace();
                    loadingLayout.setVisibility(View.VISIBLE);
                    mainLayout.setVisibility(View.INVISIBLE);
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error", "no internet connection");
                Toast.makeText(home.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}