package com.example.ticketmovie.movieapp.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ticketmovie.R;

public class PhimLiveActivity  extends Fragment {
    @Nullable
    View mview;
    HomeActivity mainActivity;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (HomeActivity) getActivity();
        mview= inflater.inflate(R.layout.activity_phimlive, container, false);
        return mview;
    }
}
