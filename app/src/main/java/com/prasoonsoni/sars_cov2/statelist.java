package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class statelist extends AppCompatActivity {
    //https://api.rootnet.in/covid19-in/stats/latest
    //https://api.covid19india.org/data.json
    LottieAnimationView loading;
    ImageView stateBackButton;
    ConstraintLayout stateLayout, stateTop;
    ListView listView;

    public static List<StateModel> stateModelList = new ArrayList<>();
    StateModel stateModel;
    StateListAdapter stateListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statelist);
        stateBackButton = findViewById(R.id.locationBackButton);
        stateLayout = findViewById(R.id.stateLayout);
        listView = findViewById(R.id.listView);
        stateTop = findViewById(R.id.topOfLayouts);
        stateTop.animate().translationYBy(1000f).setDuration(300);
        AnimationDrawable animationDrawable = (AnimationDrawable) stateLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        loading = findViewById(R.id.state_loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fetchData();
            }
        }, 2000);

        stateBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), home.class);
                startActivity(b);
            }
        });
    }
    private void fetchData(){

        String url = "https://api.covid19india.org/data.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    String list = object.getString("statewise");
                    JSONArray jsonArray = new JSONArray(list);
                    for(int i = 0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String stateName = jsonObject.getString("state");
                        Log.i("state", jsonObject.getString("state"));
                        String active = jsonObject.getString("active");
                        String deaths = jsonObject.getString("deaths");
                        String recovered = jsonObject.getString("recovered");
                        String confirmed = jsonObject.getString("confirmed");
                        String lastupdate = jsonObject.getString("lastupdatedtime");

                        stateModel = new StateModel(stateName,active,confirmed,deaths,recovered,lastupdate);
                        stateModelList.add(stateModel);
                    }
                    stateListAdapter = new StateListAdapter(statelist.this, stateModelList);
                    listView.setAdapter(stateListAdapter);
                    listView.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.INVISIBLE);


                } catch (JSONException e) {
                    e.printStackTrace();
                    listView.setVisibility(View.INVISIBLE);
                    loading.setVisibility(View.VISIBLE);
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error", "no internet connection");
                Toast.makeText(statelist.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}