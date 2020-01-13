package com.example.pythonapi.interfaces;


import com.example.pythonapi.model.Room;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface JsonApiHolder {

    @POST("prediction")
    @FormUrlEncoded
    Call<Room> predict(
            @Field("wap1") String wap1,
            @Field("wap2") String wap2,
            @Field("wap3") String wap3,
            @Field("wap4") String wap4,
            @Field("wap5") String wap5,
            @Field("wap6") String wap6,
            @Field("wap7") String wap7
    );
    @POST("prediction_new_map")
    @FormUrlEncoded
    Call<Room> predictNewMap(
            @Field("wap1") String wap1,
            @Field("wap2") String wap2,
            @Field("wap3") String wap3,
            @Field("wap4") String wap4,
            @Field("wap5") String wap5,
            @Field("wap6") String wap6,
            @Field("wap7") String wap7
    );
}
