package com.example.evergreen.Fragments;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.evergreen.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactUs extends Fragment {
    @BindView(R.id.welcome)  ImageView animatedMonkey;

    private AnimationDrawable monkeyAnimation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


}