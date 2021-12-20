package com.example.evergreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.showmenu) ImageView showMenu;
    @BindView(R.id.slide_pop_close) ImageView slide_pop_close;
    @BindView(R.id.slide_pop) RelativeLayout slide_pop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);
        ButterKnife.bind(this);
        showMenu.setOnClickListener(this);
        slide_pop_close.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view==showMenu){
            slide_pop.setVisibility(View.VISIBLE);
            showMenu.setVisibility(View.GONE);

        }
        if(view==slide_pop_close){
            slide_pop.setVisibility(View.GONE);
            showMenu.setVisibility(View.VISIBLE);

        }
    }
}