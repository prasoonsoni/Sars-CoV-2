package com.prasoonsoni.sars_cov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class banking extends AppCompatActivity {
    ConstraintLayout bankingLayout, topDonation;
    ImageView backButton, aPay, gPay, tmPay, mPay, pPay, vPay, sbiLogo;
    TextView newDelhi, name, pmCares, accno, accountNumber, ifsc, ifscNo, swift, swiftNo;
    CardView atmCardView, upiCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);

        sbiLogo = findViewById(R.id.sbiLogo);
        sbiLogo.animate().translationXBy(2000f).setDuration(800);
        newDelhi = findViewById(R.id.newDelhi);
        newDelhi.animate().translationXBy(-2000f).setDuration(800);

        name = findViewById(R.id.name);
        name.animate().translationXBy(2000f).setDuration(1000);
        pmCares = findViewById(R.id.pmCares);
        pmCares.animate().translationXBy(-2000f).setDuration(1000);


        accno = findViewById(R.id.accno);
        accno.animate().translationXBy(2000f).setDuration(1100);
        accountNumber = findViewById(R.id.accountNumber);
        accountNumber.animate().translationXBy(-2000f).setDuration(1100);


        ifsc = findViewById(R.id.ifsc);
        ifsc.animate().translationXBy(2000f).setDuration(1200);
        ifscNo = findViewById(R.id.ifscNo);
        ifscNo.animate().translationXBy(-2000f).setDuration(1200);


        swift = findViewById(R.id.swift);
        swift.animate().translationXBy(2000f).setDuration(1300);
        swiftNo = findViewById(R.id.swiftNo);
        swiftNo.animate().translationXBy(-2000f).setDuration(1300);

        atmCardView = findViewById(R.id.atmCardView);
        atmCardView.animate().alpha(1f).setDuration(500);
        upiCardView = findViewById(R.id.upiCardView);
        upiCardView.animate().alpha(1f).setDuration(700);

        topDonation = findViewById(R.id.topOfLayouts);
        topDonation.animate().translationYBy(1000f).setDuration(300);



































        bankingLayout = findViewById(R.id.bankingLayout);
        backButton = findViewById(R.id.locationBackButton);
        aPay = findViewById(R.id.aPay);
        aPay.animate().translationXBy(2000f).setDuration(800);

        gPay = findViewById(R.id.gPay);
        gPay.animate().alpha(1f).setDuration(800);

        tmPay = findViewById(R.id.tmPay);
        tmPay.animate().translationXBy(-2000f).setDuration(800);

        mPay = findViewById(R.id.mPay);
        mPay.animate().translationXBy(2000f).setDuration(1000);

        pPay = findViewById(R.id.pPay);
        pPay.animate().translationXBy(-2000f).setDuration(1000);

        vPay = findViewById(R.id.vPay);
        vPay.animate().translationYBy(-1000f).setDuration(1000);
        AnimationDrawable animationDrawable = (AnimationDrawable) bankingLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), home.class);
                startActivity(b);
            }
        });
    }
}