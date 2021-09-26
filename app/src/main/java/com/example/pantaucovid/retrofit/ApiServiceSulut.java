package com.example.pantaucovid.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceSulut {
    private static String BASE_URL = "https://api.kawalcorona.com/";
    private static Retrofit retrofit = null;
    public static ApiEndpointSulut endpoint(){

        retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create( ApiEndpointSulut.class );
    }
}
