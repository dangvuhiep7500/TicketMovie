package com.example.lib.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ChiTietPhimLive implements Serializable {
    @SerializedName("idChiTietPhimLive")
    @Expose
    private Integer idChiTietPhimLive;
    @SerializedName("idPhimLive")
    @Expose
    private Integer idPhimLive;
    @SerializedName("idUser")
    @Expose
    private Integer idUser;
    @SerializedName("idPhimLiveNavigation")
    @Expose
    private PhimLive idPhimLiveNavigation;
    @SerializedName("idUserNavigation")
    @Expose
    private User idUserNavigation;


    public ChiTietPhimLive(Integer idChiTietPhimLive, Integer idPhimLive, Integer idUser) {
        this.idChiTietPhimLive = idChiTietPhimLive;
        this.idPhimLive = idPhimLive;
        this.idUser = idUser;

    }
    public Integer getIdChiTietPhimLive() {
        return idChiTietPhimLive;
    }

    public void setIdChiTietPhimLive(Integer idChiTietPhimLive) {
        this.idChiTietPhimLive = idChiTietPhimLive;
    }

    public Integer getIdPhimLive() {
        return idPhimLive;
    }

    public void setIdPhimLive(Integer idPhimLive) {
        this.idPhimLive = idPhimLive;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }



    public PhimLive getIdPhimLiveNavigation() {
        return idPhimLiveNavigation;
    }

    public void setIdPhimLiveNavigation(PhimLive phimLiveNavigation) {
        this.idPhimLiveNavigation = idPhimLiveNavigation;
    }

    public User getIdUserNavigation() {
        return idUserNavigation;
    }
}
