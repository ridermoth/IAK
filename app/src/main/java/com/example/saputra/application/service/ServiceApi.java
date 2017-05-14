package com.example.saputra.application.service;

import com.example.saputra.application.model.ExampleRetro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Verdiyanto Saputra on 14/05/2017.
 */

public interface ServiceApi {

    String END_POINT = "questions";

    @GET(END_POINT)
    Call<List<ExampleRetro>> getData();

}
