package com.example.ticketmovie.movieapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ChiTietChieu;
import com.example.lib.Model.ChiTietPhimLive;
import com.example.lib.Model.Ve;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemVePhimLiveDaDatAdapter extends ArrayAdapter<ChiTietPhimLive> {
    Activity activity;
    int resource;
    Methods methods;
    ChiTietPhimLive a;
    public static final String BASE_URL = "https://bookingmovie20220329183802.azurewebsites.net";
    public ItemVePhimLiveDaDatAdapter(@NonNull Context context, int resource){
        super(context, resource);
        this.activity= (Activity) context;
        this.resource= resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        methods = RetrofitClient.getRetrofit(BASE_URL).create(Methods.class);
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View spView = layoutInflater.inflate(this.resource, null);
        ChiTietPhimLive phimLive = getItem(position);
        Call<ChiTietPhimLive> chiTietPhimLiveCall= methods.getIdChitietphimlive(phimLive.getIdChiTietPhimLive());
        chiTietPhimLiveCall.enqueue(new Callback<ChiTietPhimLive>() {
            @Override
            public void onResponse(Call<ChiTietPhimLive> call, Response<ChiTietPhimLive> response) {
                a = response.body();
                TextView txtphimlive = spView.findViewById(R.id.txttenphimlive);
                txtphimlive.setText(a.getIdPhimLiveNavigation().getTenPhimLive().toString());
                TextView txttheloailive = spView.findViewById(R.id.txttheloailive);
                txttheloailive.setText(a.getIdPhimLiveNavigation().getIdTheLoaiNavigation().getTenTheLoai());
                TextView txtThoigianlive = spView.findViewById(R.id.txttimelive);
                txtThoigianlive.setText(a.getIdPhimLiveNavigation().getGioBatDau().toString());
//                String thoigianlive = a.getIdPhimLiveNavigation().getGioBatDau().toString();

            }

            @Override
            public void onFailure(Call<ChiTietPhimLive> call, Throwable t) {

            }
        });
        return  spView;
    }
}
