package com.example.evergreen.Fragments;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.evergreen.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Home extends Fragment implements View.OnClickListener{
    @BindView(R.id.booking_q_menu) ImageView book_now;
    @BindView(R.id.check_available) ImageView available_trips;
    @BindView(R.id.rate_us) ImageView rate_us;
    @BindView(R.id.coming) ImageView coming;
    @BindView(R.id.frame2) FrameLayout frame2;

    private static int SPLASH_SCREEN=2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        book_now.setOnClickListener(this);
        available_trips.setOnClickListener(this);
        rate_us.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view==book_now){
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame2,new Booking());
            fragmentTransaction.commit();
            hideComingSoon();
            frame2.setVisibility(View.VISIBLE);
        }
        if (view==available_trips){
            coming.setVisibility(View.VISIBLE);
            frame2.setVisibility(View.GONE);
            hideComingSoon();
        }
        if (view==rate_us){
            coming.setVisibility(View.VISIBLE);
            frame2.setVisibility(View.GONE);
            hideComingSoon();
        }

    }
    private void hideComingSoon(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                coming.setVisibility(View.GONE);
            }
        },SPLASH_SCREEN);

    }

    @Override
    public void onStart() {
        super.onStart();
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame2,new Booking());
        fragmentTransaction.commit();
    }
}