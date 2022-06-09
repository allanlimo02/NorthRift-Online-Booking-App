package com.example.evergreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splashscreen extends AppCompatActivity {
    @BindView(R.id.splash_logo)  ImageView splash_logo;
    private static int SPLASH_SCREEN=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ButterKnife.bind(this);
        hideComingSoon();
//        splash_logo.animate()
//                .rotationY(360)
//                .rotationX(360)
//                .setDuration(2000);
//        startActivity(new Intent(this, MainActivity.class));

    }
    private void hideComingSoon(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splashscreen.this, Login_activity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);

    }
}