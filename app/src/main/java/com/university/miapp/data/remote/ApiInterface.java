package com.university.miapp.data.remote;

import com.university.miapp.data.models.Weather;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/data/2.5/weather?q=Bogota&appid=21a40b1b27948d3284ddf67e2308001e")
    Call<Weather> getTime();
}
