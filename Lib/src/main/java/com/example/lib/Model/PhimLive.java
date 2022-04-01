package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhimLive implements Serializable {

    @SerializedName("idPhimLive")
    @Expose
    private Integer idPhimLive;
    @SerializedName("idTheLoai")
    @Expose
    private Integer idTheLoai;
    @SerializedName("tenPhim")
    @Expose
    private String tenPhim;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("keyphim")
    @Expose
    private String keyphim;
    @SerializedName("gioBatDau")
    @Expose
    private String gioBatDau;
    @SerializedName("idTheLoaiNavigation")
    @Expose
    private Theloai idTheLoaiNavigation;

    public Integer getIdPhimLive() {
        return idPhimLive;
    }
    private List<ChiTietPhimLive> chiTietPhimLives = null;

    public void setIdPhim(Integer idPhimLive) {
        this.idPhimLive = idPhimLive;
    }

    public Integer getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(Integer idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getTenPhimLive() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getKeyphim() {
        return keyphim;
    }

    public void setKeyphim(String keyphim) {
        this.keyphim = keyphim;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Theloai getIdTheLoaiNavigation() {
        return idTheLoaiNavigation;
    }

    public void setIdTheLoaiNavigation(Theloai idTheLoaiNavigation) {
        this.idTheLoaiNavigation = idTheLoaiNavigation;
    }

    public List<ChiTietPhimLive> chiTietPhimLives() {
        return chiTietPhimLives;
    }

    public void setChiTietPhimLives(List<ChiTietPhimLive> chiTietPhimLives) {
        this.chiTietPhimLives = chiTietPhimLives;
    }

}