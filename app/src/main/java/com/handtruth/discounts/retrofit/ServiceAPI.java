package com.handtruth.discounts.retrofit;

import com.handtruth.discounts.pojo.Discounts;
import com.handtruth.discounts.pojo.ShopList;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceAPI {
    @GET("")
    Call<ShopList> getShops(int startShop, int endShop);

    @FormUrlEncoded
    @POST("/access")
    Call<Map<String, String>> accountAccess(@FieldMap Map<String, String> account);

    @FormUrlEncoded
    @POST("")
    Call<Discounts> getDiscount(@FieldMap Map<String, String> account);
}
