package com.handtruth.discounts.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shop {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("count")
    @Expose
    private String countOfDiscounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountOfDiscounts() {
        return countOfDiscounts;
    }

    public void setCountOfDiscounts(String countOfDiscounts) {
        this.countOfDiscounts = countOfDiscounts;
    }
}
