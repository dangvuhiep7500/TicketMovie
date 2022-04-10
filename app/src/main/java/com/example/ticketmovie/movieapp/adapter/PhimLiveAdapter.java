package com.example.ticketmovie.movieapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lib.Model.PhimLive;
//import com.example.lib.Model.PhimModel;
import com.example.ticketmovie.R;
import com.squareup.picasso.Picasso;

public class PhimLiveAdapter extends ArrayAdapter<PhimLive> {
    Activity activity;
    int resource;
    public PhimLiveAdapter(@NonNull Context context,int resource){
        super(context, resource);
        this.activity= (Activity) context;
        this.resource= resource;
    }
    @NonNull
    @Override
    public View  getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View spView = layoutInflater.inflate(this.resource, null);
        TextView txtgiobd= spView.findViewById(R.id.txtGiobd);
        TextView txtTenPhim = spView.findViewById(R.id.txttenphimlive);
        TextView txtTheloaiPL = spView.findViewById(R.id.txtTheLoaiPL);
        TextView txtMota = spView.findViewById(R.id.txtmota);

        PhimLive phimLive = getItem(position);
       // Picasso.get().load(phimModel.getImage()).into(imgposter);
        txtTenPhim.setText(phimLive.getTenPhimLive());
        txtgiobd.setText(phimLive.getGioBatDau());
        txtTheloaiPL.setText(phimLive.getIdTheLoaiNavigation().getTenTheLoai());
        txtMota.setText(phimLive.getMota());
        return spView;
    }
}
