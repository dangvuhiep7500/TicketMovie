package com.example.ticketmovie.movieapp.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ChiTietPhimLive;
import com.example.lib.Model.PhimLive;
import com.example.lib.Model.Ve;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.example.ticketmovie.movieapp.adapter.ItemLuuVeAdapter;
import com.example.ticketmovie.movieapp.adapter.ItemVePhimLiveDaDatAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListVePhimLiveDaDatActivity extends Fragment {
    Methods methods;
    List<ChiTietPhimLive> ctphimlive = new ArrayList<ChiTietPhimLive>();
    List<ChiTietPhimLive> ctphimlives = new ArrayList<ChiTietPhimLive>();
    ItemVePhimLiveDaDatAdapter itemsAdapter = null;
    ListView listViewphimlive =  null;
    public static final String BASE_URL = "https://bookingmovie20220329183802.azurewebsites.net";
    View mview;
    HomeActivity mainActivity;

    @Override
    public void onStart() {
        super.onStart();
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        listViewphimlive = mview.findViewById(R.id.listViewphimlive);
        itemsAdapter = new ItemVePhimLiveDaDatAdapter(mainActivity, R.layout.item_phimlive_dadat);
        getPhimLive();

    }
    public void getPhimLive(){
      Call<List<ChiTietPhimLive>> call = methods.getChitietphimlive();
        ctphimlives.clear();
      call.enqueue(new Callback<List<ChiTietPhimLive>>() {
          @Override
          public void onResponse(Call<List<ChiTietPhimLive>> call, Response<List<ChiTietPhimLive>> response) {
              ctphimlive = response.body();
              for(ChiTietPhimLive c : ctphimlive) {
                  if (SignInActivity.user.getIdUser().equals(c.getIdUser())) {
                      ctphimlives.add(c);
                      itemsAdapter.addAll(c);
                  }
              }
          }

          @Override
          public void onFailure(Call<List<ChiTietPhimLive>> call, Throwable t) {

          }
      });
        itemsAdapter.addAll(ctphimlives);
        listViewphimlive.setAdapter(itemsAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (HomeActivity) getActivity();
        mview= inflater.inflate(R.layout.list_phimlive_dadat, container, false);
        return mview;
    }
}
