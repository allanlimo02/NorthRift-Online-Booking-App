package com.example.evergreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.evergreen.Fragments.UserVerification;
import com.example.evergreen.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login_activity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.email) EditText email;
    @BindView(R.id.password)  EditText password;
    @BindView(R.id.login)  Button login;
    @BindView(R.id.create) TextView create;
    @BindView(R.id.forgot) TextView forgot;
    @BindView(R.id.passwordError) TextView passwordError;
    @BindView(R.id.emailError) TextView emailError;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        login.setOnClickListener(this);
        create.setOnClickListener(this);
        forgot.setOnClickListener(this);

//        firebaseAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(v==login){
            String emailinput=email.getText().toString().trim();
            String passwordinput=password.getText().toString().trim();
            if (emailinput.equals("")) {
                emailError.setText("This field cannot be blank");
            }else
                if (passwordinput.equals("")){
                    passwordError.setText("This field cannot be blank");
            }else {
                Intent intent=new Intent(this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("username",emailinput);
                startActivity(intent);
                finish();
            }

        }
        if (v==create){
            Intent intent= new Intent(Login_activity.this, CreateUser .class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
        if (v==forgot){

        }
    }
    private void firebaseLogin(){
        String emailInput=email.getText().toString().trim();
        String passwordinput=password.getText().toString().trim();
    }
    private void firebaseAuth(String email,String password){
//        firebaseAuth.addAuthStateListener();

    }
}