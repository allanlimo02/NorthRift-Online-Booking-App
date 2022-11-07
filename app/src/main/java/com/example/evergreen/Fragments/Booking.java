package com.example.evergreen.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.evergreen.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Booking extends Fragment {
//    @BindView(R.id.fromspinner) Spinner fromSpinner;
//    @BindView(R.id.tospinner) Spinner toSpinner;
    Context context;


    public Booking() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_booking, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//    22etAdapter(adapter);
    }



    @Override
    public void onStart() {
        super.onStart();

    }
}