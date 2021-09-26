package com.example.pantaucovid.retrofit;

import com.example.pantaucovid.model.CovidSulut;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointSulut {
    @GET("indonesia/provinsi")
    Call<List<CovidSulut>> getData();
}
