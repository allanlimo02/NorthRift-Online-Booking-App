package com.example.evergreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evergreen.Fragments.Home;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.showmenu) ImageView showMenu;
    @BindView(R.id.slide_pop_close) ImageView slide_pop_close;
    @BindView(R.id.slide_pop) RelativeLayout slide_pop;
    @BindView(R.id.relative_two) RelativeLayout relative_two;
    @BindView(R.id.home_txt) TextView home_txt;
    @BindView(R.id.profile_txt) TextView profile_txt;
    @BindView(R.id.my_bookings) TextView my_bookings;
    @BindView(R.id.available_trips) TextView available_trips;
    @BindView(R.id.contact_us) TextView contact_us;
    @BindView(R.id.share_app) TextView share_app;
    @BindView(R.id.username) TextView username;
    @BindView(R.id.nr_text) ImageView logo;
    @BindView(R.id.mainframe) FrameLayout frameLayout;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);
        ButterKnife.bind(this);

        showMenu.setOnClickListener(this);
        slide_pop_close.setOnClickListener(this);
        relative_two.setOnClickListener(this);
        home_txt.setOnClickListener(this);
        profile_txt.setOnClickListener(this);
        my_bookings.setOnClickListener(this);
        available_trips.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        share_app.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,new Home());
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View view) {
        if (view==showMenu){
            slide_pop.setVisibility(View.VISIBLE);
            showMenu.setVisibility(View.GONE);
            relative_two.setVisibility(View.VISIBLE);

        }
        if(view==slide_pop_close){
            slide_pop.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);
            relative_two.setVisibility(View.GONE);
        }
        if(view==relative_two){
            slide_pop.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);
            relative_two.setVisibility(View.GONE);
        }
        if(view==home_txt){
            relative_two.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);

        }
        if(view==profile_txt){
            relative_two.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);

        }
        if(view==my_bookings){
            relative_two.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);

        }
        if(view==available_trips){
            relative_two.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);

        }
        if(view==contact_us){
            relative_two.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);

        }
        if(view==share_app){
            relative_two.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);

        }
    }
    private void timeCalculator(){
        int mHour=calendar.get(Calendar.HOUR);
        username.setText(mHour);
    }
}