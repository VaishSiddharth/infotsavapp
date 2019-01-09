package com.infotsav.test.Main_Activities;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infotsav.test.R;

public class TreasurehuntActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treasurehunt);
        LinearLayout comingsoonlayout=findViewById(R.id.comingsoonlayout);
        final TextView comingsoon=findViewById(R.id.comingsoon);
        final TextView registernow=findViewById(R.id.registernow);
        Typeface font_title=Typeface.createFromAsset(getAssets(),"fonts/deadpoolmovie.otf");
        comingsoon.setTypeface(font_title);
        registernow.setTypeface(font_title);
        final AlphaAnimation anim1 = new AlphaAnimation(0.0f, 1.0f);
        //anim1.setStartOffset(200);
        anim1.setDuration(1000);
        registernow.startAnimation(anim1);
        comingsoonlayout.postDelayed(new Runnable() {
            public void run() {
                registernow.setVisibility(View.GONE);
                comingsoon.setVisibility(View.VISIBLE);
                comingsoon.startAnimation(anim1);
            }
        }, 2000);
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 5000);
    }
}
