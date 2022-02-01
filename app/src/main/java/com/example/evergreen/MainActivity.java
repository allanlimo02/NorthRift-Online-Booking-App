package com.example.evergreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentTransaction;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evergreen.Fragments.ContactUs;
import com.example.evergreen.Fragments.Home;

import java.time.LocalTime;
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
    @BindView(R.id.user_icon) ImageView user_icon;
    @BindView(R.id.signout) TextView signout;
    Calendar calendar;
    LocalTime time;
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
            onDestroy();


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

}