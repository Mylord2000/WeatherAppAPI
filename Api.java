package com.example.a1.ret;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    public String BASE_URL = "https://query.yahooapis.com";

    @GET("/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Almaty%2C%20kz%22)&format=json")
    Call<Example> getExample();

}
