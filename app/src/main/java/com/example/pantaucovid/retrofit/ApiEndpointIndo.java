package com.example.pantaucovid.retrofit;

import com.example.pantaucovid.model.CovidIndo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointIndo {
    @GET("indonesia")
    Call<List<CovidIndo>> getData();
}
