package com.example.ticketmovie.movieapp.activities;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ItemPL;
import com.example.lib.Model.PhimModel;
import com.example.lib.Model.videoLiveStream;
import com.example.lib.RetrofitClient;
import com.example.ticketmovie.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrailerMovieActivity extends AppCompatActivity {
    public YouTubePlayerView youTubePlayerView;
    TextView thongtin;
    Methods methods;
    videoLiveStream videoLiveStream;
    String idLive= "FJJiui1anYc";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String APIKey ="https://www.googleapis.com";
        methods = RetrofitClient.getRetrofit(APIKey).create(Methods.class);
        Call<videoLiveStream> videoLive = methods.getLiveStream();
        videoLive.enqueue(new Callback<videoLiveStream>() {
            @Override
            public void onResponse(Call<videoLiveStream> call, Response<videoLiveStream> response) {
               videoLiveStream = response.body();
            }
            @Override
            public void onFailure(Call<videoLiveStream> call, Throwable t) {
            }
        });
        Integer length= videoLiveStream.getPageInfo().getResultsPerPage();
        idLive= videoLiveStream.getItems().get(length-1).getId().getVideoId();
        setContentView(R.layout.trailer_movie);
        PhimModel phimModel = (PhimModel) getIntent().getSerializableExtra("phimModel");
        youTubePlayerView=findViewById(R.id.abc);
        getLifecycle().addObserver(youTubePlayerView);
        String trailer = MovieDetailActivity.a.split("!!!")[0];
        String thongtinphim = MovieDetailActivity.a.split("!!!")[1];
        thongtin = (TextView) findViewById(R.id.thongtinphim);
        thongtin.setText(thongtinphim);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo("FJJiui1anYc", 0);
            }
        });
    }
}
