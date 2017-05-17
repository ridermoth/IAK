package com.example.saputra.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RetroActivity extends AppCompatActivity {

    private TextView mTxtJudul;
    private  TextView mTxtTentang;
    private  TextView mTxtIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro);

        mTxtJudul = (TextView) findViewById(R.id.tv_judul2);
        mTxtTentang= (TextView) findViewById(R.id.tv_tentang2);
        mTxtIsi = (TextView) findViewById(R.id.tv_isi2);

        Intent mIntent = getIntent();
        String judul = mIntent.getStringExtra("judul");
        mTxtJudul.setText(judul);
        String tentang = mIntent.getStringExtra("tentang");
        mTxtTentang.setText(tentang);
        String isi = mIntent.getStringExtra("isi");
        mTxtIsi.setText(isi);
    }
}
