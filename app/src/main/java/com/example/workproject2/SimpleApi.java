package com.example.workproject2;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface SimpleApi {

    @POST("/api/login")
    Call<Post> createPost(@Body Post post);

    @GET("/api/get_devices")
    Call<Device[]> createDevices(
            @QueryMap Map<String, String> firstTry
            );

    @GET("/api/get_devices")
    Call<DeviceTwo[]> createDevicesTwo(
            @QueryMap Map<String, String> firstTry
    );
}