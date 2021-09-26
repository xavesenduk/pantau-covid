package com.example.pantaucovid.retrofit;

import com.example.pantaucovid.model.CovidGlobal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointGlobal {
    @GET("positif")
    Call<CovidGlobal> getData();
}
