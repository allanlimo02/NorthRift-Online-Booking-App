package com.example.evergreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.evergreen.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login_activity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.email) EditText email;
    @BindView(R.id.password)  EditText password;
    @BindView(R.id.login)  Button login;
    @BindView(R.id.create) TextView create;
    @BindView(R.id.forgot) TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        if(v==login){

        }
        if (v==create){

        }
        if (v==forgot){

        }
    }
}