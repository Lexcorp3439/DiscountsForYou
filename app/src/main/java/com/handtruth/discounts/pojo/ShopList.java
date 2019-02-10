package com.handtruth.discounts.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopList {

    @SerializedName("shops")
    @Expose
    private ArrayList<Shop> shopList = new ArrayList<>();

    public ArrayList<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(ArrayList<Shop> shopList) {
        this.shopList = shopList;
    }
}
