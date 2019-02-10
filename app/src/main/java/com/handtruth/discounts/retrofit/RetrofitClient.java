package com.handtruth.discounts.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final static String URL = "https://www.handtruth.com/discount/api";
    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServiceAPI getServiceAPI(){
        return getRetrofitInstance().create(ServiceAPI.class);
    }
}
