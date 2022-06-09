package com.example.evergreen.Fragments;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.evergreen.Constants;
import com.example.evergreen.MainActivity;
import com.example.evergreen.MessagesSent;
import com.example.evergreen.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactUs extends Fragment implements View.OnClickListener{
    @BindView(R.id.submitButton) Button submitbtn;
    @BindView(R.id.emailInput) EditText emailInput;
    @BindView(R.id.usernameInput) EditText usernameInput;
    @BindView(R.id.messageInput) EditText messageInput;

    private AnimationDrawable monkeyAnimation;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference ref = database.getReference();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ButterKnife.bind(this,view);
        submitbtn.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        if (view==submitbtn){
            String username=usernameInput.getText().toString().trim();
            String email=emailInput.getText().toString().trim();
            String message=messageInput.getText().toString().trim();
            MessagesSent messagesSent=new MessagesSent(username,email,message);
            if (username.equals("")){
                usernameInput.setError("This field is required");
            }else
            if (email.equals("")){
                emailInput.setError("This field is required");
            }else
                if(message.equals("")){
                    emailInput.setError("This field is required");
                }else {
//                    messagesSent=FirebaseDatabase
//                            .getInstance()
//                            .getReference()
//                            .child();
                    Toast.makeText(getActivity(), "Submited", Toast.LENGTH_SHORT).show();
                    emailInput.setText("");
                    usernameInput.setText("");
                    messageInput.setText("");
                }
        }

    }
}