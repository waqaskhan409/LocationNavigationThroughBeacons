package com.example.pythonapi.rest_api;

import android.provider.SyncStateContract;

import com.example.pythonapi.interfaces.JsonApiHolder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {
    private static String endPoint = "http://192.168.43.31:33/api/";

    public static JsonApiHolder getApi() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonApiHolder service = retrofit.create(JsonApiHolder.class);
        return service;
    }
}