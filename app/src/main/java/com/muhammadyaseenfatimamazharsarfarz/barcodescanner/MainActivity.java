package com.muhammadyaseenfatimamazharsarfarz.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    Animation animimgpage,  btthree ,bttone;

    public static TextView scanTextView;
    TextView next,subtitlepage;
    private AdView adViewMainActivity;
    ImageView imgpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (TextView) findViewById(R.id.next);
        subtitlepage=findViewById(R.id.subtitlepage);
        adViewMainActivity = findViewById(R.id.adViewMainActivity);
        imgpage = findViewById(R.id.imgpage);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adViewMainActivity.loadAd(adRequest);

        animimgpage = AnimationUtils.loadAnimation(this, R.anim.animimgpage);
        imgpage.startAnimation(animimgpage);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        bttone=AnimationUtils.loadAnimation(this,R.anim.bttone);
        next.startAnimation(btthree);
        subtitlepage.startAnimation(bttone);




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScanViewActivity.class));


            }
        });

        scanTextView = (TextView) findViewById(R.id.t);

    }

}
