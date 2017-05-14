package com.example.saputra.application.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saputra.application.R;
import com.example.saputra.application.adapter.HomeAdapter;
import com.example.saputra.application.interactor.HomeInterface;
import com.example.saputra.application.mainhome.HomePresenter;
import com.example.saputra.application.model.ExampleRetro;
import com.example.saputra.application.model.HomeModel;
import com.example.saputra.application.service.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private TextView mTxtUsername;

    private TextView textView;
    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private HomeInterface mHomeInterface;
    private ArrayList<HomeModel> mHomeModel;

    private List<ExampleRetro> mExampleRetros;

    public static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTxtUsername = (TextView) findViewById(R.id.txt_username2);

        Intent mIntent = getIntent();
        String username = mIntent.getStringExtra("username");
        mTxtUsername.setText("Selamat datang, " + username);

        mHomeInterface = new HomePresenter(this);
        mHomeModel = new ArrayList<>();
        mHomeInterface.showList(mHomeModel);
        initView();
        getData();
    }

    private void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.list_item);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mHomeAdapter = new HomeAdapter(this, mHomeModel);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    private void getData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceApi serviceApi = retrofit.create(ServiceApi.class);
        Call<List<ExampleRetro>> call = serviceApi.getData();
        call.enqueue(new Callback<List<ExampleRetro>>() {
            @Override
            public void onResponse(Call<List<ExampleRetro>> call, Response<List<ExampleRetro>> response) {
                // harusnya di adapter
                mExampleRetros = response.body();
                for(int i=0;i<mExampleRetros.size();i++){
                    String judul = mExampleRetros.get(i).getJudul();
                    Toast.makeText(HomeActivity.this, "" + judul, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ExampleRetro>> call, Throwable t) {

            }
        });
    }
}
