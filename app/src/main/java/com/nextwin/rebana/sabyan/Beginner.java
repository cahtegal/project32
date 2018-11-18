package com.nextwin.rebana.sabyan;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Beginner extends AppCompatActivity {

    TextView teksSlap,teksDum,teksSlap1,teksTak2,teksKa1,teksKa2,teksTak;
    ImageView imgDarbuka,imgRebanaKecil1,imgRebanaKecil2;
    private int sslap;
    private int sdum;
    private int sslap1;
    private int stak2;
    private int ska1;
    private int ska2;
    private int stak;
    private int skecil1;
    private int skecil2;
    private SoundPool sp;
    AudioManager mAudioManager;
    RelativeLayout layUtama;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginner);
        deklarasi();
        action();
    }

    @Override
    public void onPause() {
        // This method should be called in the parent Activity's onPause() method.
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        // This method should be called in the parent Activity's onResume() method.
        if (mAdView != null) {
            mAdView.resume();
        }

    }

    @Override
    public void onDestroy() {
        // This method should be called in the parent Activity's onDestroy() method.
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }


    private void deklarasi() {
        mAdView = findViewById(R.id.adview);
        layUtama = findViewById(R.id.layUtama);
        imgDarbuka = findViewById(R.id.imgDarbuka);
        imgRebanaKecil1 = findViewById(R.id.rebana_kecil1);
        imgRebanaKecil2 = findViewById(R.id.rebana_kecil2);
        teksDum = findViewById(R.id.teksDum);
        teksKa1 = findViewById(R.id.teksKa1);
        teksKa2 = findViewById(R.id.teksKa2);
        teksSlap = findViewById(R.id.teksSlap);
        teksTak = findViewById(R.id.teksTak);
        teksSlap1 = findViewById(R.id.teksRol1);
        teksTak2 = findViewById(R.id.teksRol2);
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sp = new SoundPool.Builder().setMaxStreams(5).build();
        } else {
            sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }
        sslap = sp.load(this, R.raw.uo3, 1);
        sdum = sp.load(this, R.raw.dum, 1);
        sslap1 = sp.load(this, R.raw.slap, 1);
        stak2 = sp.load(this, R.raw.tak, 1);
        ska1 = sp.load(this, R.raw.uo4, 1);
        ska2 = sp.load(this, R.raw.ka, 1);
        stak = sp.load(this, R.raw.tak, 1);
        skecil1 = sp.load(this, R.raw.uo1, 1);
        skecil2 = sp.load(this, R.raw.uo1, 1);
    }

    private void action() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
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
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }
        });

        if (TemaDarbuka.temaDarbuka == 0) {
            layUtama.setBackground(getResources().getDrawable(R.drawable.bg1));
        } else if (TemaDarbuka.temaDarbuka == 1) {
            layUtama.setBackground(getResources().getDrawable(R.drawable.bg2));
        } else if (TemaDarbuka.temaDarbuka == 2) {
            layUtama.setBackground(getResources().getDrawable(R.drawable.bg3));
        } else if (TemaDarbuka.temaDarbuka == 3) {
            layUtama.setBackground(getResources().getDrawable(R.drawable.bg4));
        }

        teksDum.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSound(sdum,motionEvent, teksDum);
            }
        });

        teksTak.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSound(stak,motionEvent, teksTak);
            }
        });

        teksKa1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSound(ska1,motionEvent, teksKa1);
            }
        });

        teksKa2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSound(ska2,motionEvent, teksKa2);
            }
        });

        teksSlap1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSound(sslap1,motionEvent, teksSlap1);
            }
        });

        teksTak2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSound(stak2,motionEvent, teksTak2);
            }
        });

        teksSlap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSound(sslap,motionEvent, teksSlap);
            }
        });

        imgRebanaKecil1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSoundKecil(skecil1,motionEvent, imgRebanaKecil1);
            }
        });

        imgRebanaKecil2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return playSoundKecil(skecil2,motionEvent, imgRebanaKecil2);
            }
        });
    }

    private boolean playSound(int id, MotionEvent motionEvent,TextView teksView) {
        Log.d("Motionsss  ",String.valueOf(id));
        if (motionEvent == null || motionEvent.getAction() == 0) {
            float origionalVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            sp.play(id, origionalVolume, origionalVolume, 0, 0, 1.0f);
            imgDarbuka.startAnimation(AnimationUtils.loadAnimation(Beginner.this,R.anim.zoom_out));
            teksView.startAnimation(AnimationUtils.loadAnimation(Beginner.this,R.anim.zoom_in));
        }
        return true;
    }
    private boolean playSoundKecil(int id, MotionEvent motionEvent,ImageView imgView) {
        Log.d("Motionsss  ",String.valueOf(id));
        if (motionEvent == null || motionEvent.getAction() == 0) {
            float origionalVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            sp.play(id, origionalVolume, origionalVolume, 0, 0, 1.0f);
            imgView.startAnimation(AnimationUtils.loadAnimation(Beginner.this,R.anim.zoom_in));
        }
        return true;
    }
}
