package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class worldwide_cases extends AppCompatActivity {
    ConstraintLayout worldwideConstraintLayout, topOfLayout;
    ImageView worldwideBackButton;
    private TextView confirmedCases, todayConfirmed, recoveredCases, todayRecovered, deaths, todayDeaths, activeCases, criticalCases;
    PieChart pieChart;
    private LinearLayout confirmedLayout, recoveredLayout, deathsLayout, activeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldwide_cases);
        worldwideConstraintLayout = findViewById(R.id.worldwideConstraintlayout);
        AnimationDrawable ad = (AnimationDrawable) worldwideConstraintLayout.getBackground();
        ad.setEnterFadeDuration(2000);
        ad.setExitFadeDuration(4000);
        ad.start();
        topOfLayout = findViewById(R.id.topOfLayouts);
        topOfLayout.animate().translationYBy(1000f).setDuration(300);
        confirmedLayout = findViewById(R.id.confirmedLayout);
        confirmedLayout.animate().translationXBy(-2000f).setDuration(700);
        recoveredLayout = findViewById(R.id.recoveredLayout);
        recoveredLayout.animate().translationXBy(-2000f).setDuration(800);
        deathsLayout = findViewById(R.id.deathsLayout);
        deathsLayout.animate().translationXBy(-2000f).setDuration(900);
        activeLayout = findViewById(R.id.activeLayout);
        activeLayout.animate().translationXBy(-2000f).setDuration(1000);



        confirmedCases = findViewById(R.id.wConfirmedCases);
        confirmedCases.animate().translationXBy(2000f).setDuration(700);

        todayConfirmed = findViewById(R.id.wTodayConfirmed);
        todayConfirmed.animate().translationXBy(-2000f).setDuration(700);

        recoveredCases = findViewById(R.id.wRecoveredCases);
        recoveredCases.animate().translationXBy(2000f).setDuration(800);

        todayRecovered = findViewById(R.id.wTodayRecovered);
        todayRecovered.animate().translationXBy(-2000f).setDuration(800);

        deaths = findViewById(R.id.wDeaths);
        deaths.animate().translationXBy(2000f).setDuration(900);

        todayDeaths = findViewById(R.id.wTodayDeaths);
        todayDeaths.animate().translationXBy(-2000f).setDuration(900);

        activeCases = findViewById(R.id.wActiveCases);
        activeCases.animate().translationXBy(2000f).setDuration(1000);

        criticalCases = findViewById(R.id.wCriticalCases);
        criticalCases.animate().translationXBy(-2000f).setDuration(1000);

        worldwideBackButton = findViewById(R.id.locationBackButton);
        pieChart = findViewById(R.id.pieChart);
        getData();
        worldwideBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),home.class);
                startActivity(back);
            }
        });

    }

    public void getData(){
        String url = "https://disease.sh/v2/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject response = new JSONObject(s);
                    confirmedCases.setText(response.getString("cases"));
                    todayConfirmed.setText("+ " + response.getString("todayCases"));
                    recoveredCases.setText(response.getString("recovered"));
                    todayRecovered.setText("+ " + response.getString("todayRecovered"));
                    deaths.setText(response.getString("deaths"));
                    todayDeaths.setText("+ " + response.getString("todayDeaths"));
                    activeCases.setText(response.getString("active"));
                    criticalCases.setText(response.getString("critical"));
                    pieChart.addPieSlice(new PieModel("CONFIRMED", Integer.parseInt(confirmedCases.getText().toString()), Color.parseColor("#FFA726")));
                    pieChart.addPieSlice(new PieModel("RECOVERED", Integer.parseInt(recoveredCases.getText().toString()), Color.parseColor("#66BB6A")));
                    pieChart.addPieSlice(new PieModel("DEATHS", Integer.parseInt(deaths.getText().toString()), Color.parseColor("#EF5350")));
                    pieChart.addPieSlice(new PieModel("ACTIVE", Integer.parseInt(activeCases.getText().toString()), Color.parseColor("#29B6F6")));
                    pieChart.startAnimation();
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error", "no internet connection");
                Toast.makeText(worldwide_cases.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}