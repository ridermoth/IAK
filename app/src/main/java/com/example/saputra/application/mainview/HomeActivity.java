package com.example.saputra.application.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.saputra.application.R;
import com.example.saputra.application.adapter.City;
import com.example.saputra.application.adapter.CityAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView mTxtUsername;

    private final String city_names[] = {
            "Malang",
            "Bandung",
            "Yogyakarta",
            "Semarang",
    };

    private final String city_image_urls[] = {
            "https://api.learn2crack.com/android/images/donut.png",
            "https://api.learn2crack.com/android/images/eclair.png",
            "https://api.learn2crack.com/android/images/froyo.png",
            "https://api.learn2crack.com/android/images/ginger.png",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTxtUsername = (TextView) findViewById(R.id.txt_username2);

        Intent mIntent = getIntent();
        String username = mIntent.getStringExtra("username");
        mTxtUsername.setText("Selamat datang, " + username);
        
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<City> cities = prepareData();
        CityAdapter adapter = new CityAdapter(getApplicationContext(), cities);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<City> prepareData() {
        ArrayList<City> cities = new ArrayList<>();
        for(int i=0;i<city_names.length;i++){
            City city = new City();
            city.setCityName(city_names[i]);
            city.setImageUrl(city_image_urls[i]);
            cities.add(city);
        }
        return cities;
    }
}
