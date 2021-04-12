package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class country_cases extends AppCompatActivity {
        ConstraintLayout searchCountryConstraintLayout;
        ConstraintLayout topCountryCases;
        TextView confirmedCasesUpdate;
        TextView confirmedCasesTodayUpdate;
        TextView activeCasesUpdate;
        TextView deathsUpdate;
        TextView todayDeathUpdate;
        TextView recoveredUpdate;
        TextView todayRecoveredUpdate;
        TextView countryName;
        ImageView countryFlag;
        EditText countryNameEditText;
        Button searchAnotherCountry;
        ImageView searchButton;
        CardView deathCardView;
        CardView confirmedCardView;
        CardView recoveredCardView;
        CardView activeCardView;
        LinearLayout searchLinearLayout;
        ImageView countryCasesBackButton;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent back = new Intent(getApplicationContext(),home.class);
        startActivity(back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_cases);
        searchCountryConstraintLayout = findViewById(R.id.searchCountryConstraintLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) searchCountryConstraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        searchButton = findViewById(R.id.searchButton);
        searchAnotherCountry = findViewById(R.id.searchAnotherCountryButton);
        countryName = findViewById(R.id.countryName);
        countryFlag = findViewById(R.id.countryFlag);
        countryNameEditText = findViewById(R.id.countryNameEditText);
        topCountryCases = findViewById(R.id.topOfLayouts);
        topCountryCases.animate().translationYBy(1000f).setDuration(300);
        confirmedCasesUpdate = findViewById(R.id.confirmedCasesUpdate);
        confirmedCasesTodayUpdate = findViewById(R.id.confirmedCasesTodayUpdate);
        activeCasesUpdate = findViewById(R.id.activeCasesUpdate);
        deathsUpdate = findViewById(R.id.deathsUpdate);
        todayDeathUpdate = findViewById(R.id.todayDeathUpdate);
        recoveredUpdate = findViewById(R.id.recoveredUpdate);
        todayRecoveredUpdate = findViewById(R.id.todayRecoveredUpdate);
        searchLinearLayout = findViewById(R.id.searchLinearLayout);
        countryCasesBackButton = findViewById(R.id.locationBackButton);
        searchLinearLayout.animate().alpha(1f).setDuration(500);
        //
        deathCardView = findViewById(R.id.deathCardView);
        recoveredCardView = findViewById(R.id.recoveredCardView);
        activeCardView = findViewById(R.id.activeCardView);
        confirmedCardView = findViewById(R.id.confirmedCardView);
        //
        countryCasesBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent countryCasesToHome = new Intent(getApplicationContext(), home.class);
                startActivity(countryCasesToHome);
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    DownloadCountryData downloadCountryData = new DownloadCountryData();
                    downloadCountryData.execute("https://disease.sh/v2/countries/" + countryNameEditText.getText().toString());
                    InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    mgr.hideSoftInputFromWindow(countryNameEditText.getWindowToken(),0);
                } catch(Exception e){
                    Toast.makeText(country_cases.this, "Cannot find information", Toast.LENGTH_SHORT).show();
                }

            }
        });

        searchAnotherCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryNameEditText.setText("");
                countryFlag.animate().alpha(0f).setDuration(600);
                countryName.animate().alpha(0f).setDuration(600);
                searchAnotherCountry.animate().translationXBy(-2000f).setDuration(500);
                confirmedCardView.animate().translationXBy(-2000f).setDuration(700);
                recoveredCardView.animate().translationXBy(-2000f).setDuration(900);
                deathCardView.animate().translationXBy(-2000f).setDuration(1100);
                activeCardView.animate().translationXBy(-2000f).setDuration(1300);
                searchLinearLayout.animate().translationXBy(-2000f).setDuration(500);
                searchAnotherCountry.setClickable(false);
                searchButton.setClickable(true);

            }
        });

    }
    public class DownloadCountryData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {

                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {

            try {
                JSONObject jsonObject = new JSONObject(result);
                String confirmedCases = jsonObject.getString("cases");
                confirmedCasesUpdate.setText(confirmedCases);
                String confirmedCasesToday = jsonObject.getString("todayCases");
                confirmedCasesTodayUpdate.setText(confirmedCasesToday);
                String activeCases = jsonObject.getString("active");
                activeCasesUpdate.setText(activeCases);
                String recoveredCases = jsonObject.getString("recovered");
                recoveredUpdate.setText(recoveredCases);
                String recoveredCasesToday = jsonObject.getString("todayRecovered");
                todayRecoveredUpdate.setText(recoveredCasesToday);
                String totalDeaths = jsonObject.getString("deaths");
                deathsUpdate.setText(totalDeaths);
                String totalDeathsToday = jsonObject.getString("todayDeaths");
                todayDeathUpdate.setText(totalDeathsToday);
                String newObject = jsonObject.getString("countryInfo");
                JSONObject forFlag = new JSONObject(newObject);
                String flag = forFlag.getString("flag");
                Picasso.with(getApplicationContext()).load(flag).into(countryFlag);
                ////
                searchButton.setClickable(false);
                searchAnotherCountry.setClickable(true);
                ////
                
                ////
                countryFlag.animate().alpha(1f).setDuration(600);
                countryName.animate().alpha(1f).setDuration(600);
                searchAnotherCountry.animate().translationXBy(2000f).setDuration(500);
                confirmedCardView.animate().translationXBy(2000f).setDuration(700);
                recoveredCardView.animate().translationXBy(2000f).setDuration(900);
                deathCardView.animate().translationXBy(2000f).setDuration(1100);
                activeCardView.animate().translationXBy(2000f).setDuration(1300);
                searchLinearLayout.animate().translationXBy(2000f).setDuration(500);
                countryName.setText(countryNameEditText.getText().toString().toUpperCase());

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(country_cases.this, "Cannot find information", Toast.LENGTH_SHORT).show();
            }
        }
    }
}