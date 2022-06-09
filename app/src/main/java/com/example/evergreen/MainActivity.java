package com.example.evergreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evergreen.Fragments.ContactUs;
import com.example.evergreen.Fragments.Home;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
    @BindView(R.id.user_icon) ImageView user_icon;
    @BindView(R.id.signout) TextView signout;
    @BindView(R.id.locationbotom) TextView locationbotom;
    @BindView(R.id.swiper) RelativeLayout swiper;
    FusedLocationProviderClient fusedLocationProviderClient;
    Calendar calendar;
    LocalTime time;
    MainActivity mainActivity;
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;
    String notificationBody="Your session has ended";
    String sesionUsername="Allan";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);
        ButterKnife.bind(this);

        Intent intent=getIntent();
//        String sesionUsername=intent.getStringExtra("username");
        showMenu.setOnClickListener(this);
        slide_pop_close.setOnClickListener(this);
        relative_two.setOnClickListener(this);
        home_txt.setOnClickListener(this);
        profile_txt.setOnClickListener(this);
        my_bookings.setOnClickListener(this);
        available_trips.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        share_app.setOnClickListener(this);
        user_icon.setOnClickListener(this);
        signout.setOnClickListener(this);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getPermission();
//        swiper.setOnSwi

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
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainframe,new Home());
            fragmentTransaction.commit();

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
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainframe,new ContactUs());
            fragmentTransaction.commit();


        }
        if(view==share_app){
            relative_two.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainframe,new ContactUs());
            fragmentTransaction.commit();

        }
        if (view==user_icon){
            relative_two.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainframe,new Home());
            fragmentTransaction.commit();
            notiCall(sesionUsername,notificationBody);
            notificationManagerCompat.notify(1,notification);

        }
        if(view==signout){
            notiCall(sesionUsername,notificationBody);
            notificationManagerCompat.notify(1,notification);
            Intent intent=new Intent(this,Login_activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);



        }
    }
    private void timeCalculator(){
        int mHour=calendar.get(Calendar.HOUR);
        username.setText(mHour);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

//                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }
    void notiCall(String body, String title){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel("myCh","My Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"myCh")
                    .setSmallIcon(android.R.drawable.stat_notify_sync)
                    .setContentTitle(title)
                    .setContentText(body);

            notification=builder.build();
            notificationManagerCompat=NotificationManagerCompat.from(this);

        }
    }
    private void getPermission(){
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //If permision granted, do it
            getLocation();

        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location=task.getResult();
                if (location!=null){
                    Geocoder geocoder=new Geocoder(MainActivity.this, Locale.getDefault());
                    //Address List
                    try {
                        List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                        locationbotom.setVisibility(View.VISIBLE);
                        locationbotom.setText(addresses.get(0).getLocality());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {


                }

            }
        });
    }

}