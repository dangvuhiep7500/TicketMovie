package com.example.ticketmovie.movieapp.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.Ve;
import com.example.ticketmovie.R;
import com.example.ticketmovie.movieapp.adapter.ItemLuuVeAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListVePhimLiveDaDatActivity extends Fragment {
    Methods methods;
    List<Ve> ves = new ArrayList<Ve>();
    List<Ve> VeID= new ArrayList<Ve>();
    ListView listView = null;
    ItemLuuVeAdapter itemsAdapter = null;
    public static final String BASE_URL = "https://bookingmovie20220329183802.azurewebsites.net";
    View mview;
    HomeActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainActivity = (HomeActivity) getActivity();
        mview= inflater.inflate(R.layout.list_phimlive_dadat, container, false);
        return mview;
    }
}
