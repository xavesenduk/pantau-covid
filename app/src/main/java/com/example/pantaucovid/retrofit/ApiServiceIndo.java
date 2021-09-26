package com.example.pantaucovid.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceIndo {
    private static String BASE_URL = "https://api.kawalcorona.com/";
    private static Retrofit retrofit = null;
    public static ApiEndpointIndo endpoint(){

        retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create( ApiEndpointIndo.class );
    }
}
