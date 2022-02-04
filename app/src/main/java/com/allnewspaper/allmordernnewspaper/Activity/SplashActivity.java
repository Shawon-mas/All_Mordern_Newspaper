package com.allnewspaper.allmordernnewspaper.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.allnewspaper.allmordernnewspaper.R;
import com.rbddevs.splashy.Splashy;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Splashy(this).setLogo(R.drawable.icon)
                .setTitle("All Modern Newspaper")
                .setTitleColor(R.color.colorPrimaryDark)
                .setSubTitle("Get all latest News")
                .setProgressColor(R.color.colorPrimaryDark)
                .setBackgroundResource(R.color.white)
                .setAnimation(Splashy.Animation.SLIDE_IN_LEFT_RIGHT,800)
                .setFullScreen(true)
                .setTime(3000)
                .show();
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        }, 3000);
    }
}