package com.example.evergreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splashscreen extends AppCompatActivity {
    @BindView(R.id.splash_logo)  ImageView splash_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ButterKnife.bind(this);
        splash_logo.animate()
                .rotationY(360)
                .rotationX(360)
                .setDuration(2000);
        startActivity(new Intent(this, MainActivity.class));
    }
}