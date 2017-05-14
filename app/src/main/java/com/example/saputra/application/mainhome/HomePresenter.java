package com.example.saputra.application.mainhome;

import android.content.Context;

import com.example.saputra.application.interactor.HomeInterface;
import com.example.saputra.application.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by Verdiyanto Saputra on 14/05/2017.
 */

public class HomePresenter implements HomeInterface {

    private Context mContext;
    private ArrayList<HomeModel> mHomeModels;

    public HomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void showList(ArrayList<HomeModel> homeModels) {
        mHomeModels = homeModels;

        mHomeModels.add(new HomeModel("Irwan", "Pamulang", "irwancannady@gmail.com", "8818188181"));
        mHomeModels.add(new HomeModel("Cannady", "Jakarta", "cannady@gmail.com", "88123188181"));
        mHomeModels.add(new HomeModel("Verdi", "Bandung", "verdi@gmail.com", "881818828188181"));
        mHomeModels.add(new HomeModel("Alex", "Tangerang", "alex@gmail.com", "8818188181"));
        mHomeModels.add(new HomeModel("Susi", "Pamulang", "susi@gmail.com", "8818188181"));

    }
}
