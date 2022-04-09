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
import com.example.lib.Model.PhimLive;
import com.example.lib.Model.PhimModel;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.example.ticketmovie.movieapp.adapter.ItemAdapter;
import com.example.ticketmovie.movieapp.adapter.PhimLiveAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhimLiveActivity  extends Fragment {
    @Nullable
    Methods methods;
    List<PhimLive> phimLiveList = new ArrayList<PhimLive>();
    ListView listView;
    PhimLiveAdapter itemsAdapter = null;
    View mview;
    HomeActivity mainActivity;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (HomeActivity) getActivity();
        mview= inflater.inflate(R.layout.activity_phimlive, container, false);
        methods = RetrofitClient.getRetrofit(null).create(Methods.class);
        listView = mview.findViewById(R.id.listView);
        itemsAdapter = new PhimLiveAdapter(mainActivity, R.layout.item_movie_phimlive);
        Call<List<PhimLive>> call = methods.getPhimLive();
        call.enqueue(new Callback<List<PhimLive>>() {
            @Override
            public void onResponse(Call<List<PhimLive>> call, Response<List<PhimLive>> response) {
                phimLiveList= response.body();
                itemsAdapter.addAll(response.body());

            }

            @Override
            public void onFailure(Call<List<PhimLive>> call, Throwable t) {

            }
        });
        itemsAdapter.addAll(phimLiveList);
        listView.setAdapter(itemsAdapter);
        return mview;
    }
}
