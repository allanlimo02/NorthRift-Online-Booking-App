package com.example.evergreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateUser extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.email)  EditText email;
    @BindView(R.id.password)  EditText password;
    @BindView(R.id.signup) Button signup;
    @BindView(R.id.confirmpassword) EditText confirmPassword;
    @BindView(R.id.login)  TextView logintext;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        ButterKnife.bind(this);
        signup.setOnClickListener(this);
        logintext.setOnClickListener(this);
        mAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {

        if (view==signup){
            String password1=password.getText().toString().trim();
            String password2=confirmPassword.getText().toString().trim();

            if(password1.equals(password2)){



            }else {
                password.setError("");
                confirmPassword.setError("passwords does not match");
            }
        }
        if (view== logintext){
            Intent intent= new Intent(CreateUser.this,Login_activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }
    private void createNewUser(String mail,String pass){
        String emailInput=email.getText().toString().trim();
        String passwordInput=password.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(emailInput,passwordInput)
                .addOnCompleteListener(this,task -> {
                   if (task.isSuccessful()){
                       Intent intent= new Intent(CreateUser.this,MainActivity.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);
                       finish();
                   }else {
                       Toast.makeText(this, "Something went wrong, \n please try again", Toast.LENGTH_SHORT).show();
                   }
                });

    }
}