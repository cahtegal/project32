package com.nextwin.rebana.sabyan;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class JenisDarbuka extends AppCompatActivity {

    LinearLayout layDarbuka1,layDarbuka2;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jenis_darbuka);
        deklarasi();
        action();
    }

    private void deklarasi() {
        imgBack = findViewById(R.id.imgBack);
        layDarbuka1 = findViewById(R.id.layDarbuka1);
        layDarbuka2 = findViewById(R.id.layDarbuka2);
    }

    private void action() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBack.startAnimation(AnimationUtils.loadAnimation(JenisDarbuka.this,R.anim.zoom_out2));
                finish();
            }
        });
        layDarbuka1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layDarbuka1.startAnimation(AnimationUtils.loadAnimation(JenisDarbuka.this,R.anim.zoom_out2));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(JenisDarbuka.this,Beginner.class));
                        iklan();
                    }
                },300);
            }
        });

        layDarbuka2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layDarbuka2.startAnimation(AnimationUtils.loadAnimation(JenisDarbuka.this,R.anim.zoom_out2));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(JenisDarbuka.this,MasterDarbuka.class));
                        iklan();
                    }
                },300);
            }
        });
    }
    private void iklan() {
        final InterstitialAd mInterstitialAd = new InterstitialAd(JenisDarbuka.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5730449577374867/9398938216");
        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
}
