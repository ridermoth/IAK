package com.example.saputra.application.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Verdiyanto Saputra on 14/05/2017.
 */


public class ExampleRetro {

    @SerializedName("tentang")
    @Expose
    private String tentang;

    @SerializedName("judul")
    @Expose
    private String judul;

    @SerializedName("isi")
    @Expose
    private String isi;

    public String getTentang() {
        return tentang;
    }

    public void setTentang(String tentang) {
        this.tentang = tentang;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }


}
