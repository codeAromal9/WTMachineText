package com.example.wtmachinetest.Api;

import com.example.wtmachinetest.Models.Products;
import com.example.wtmachinetest.Models.Details;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("products")
    Call<List<Products>> getProductList();

    @GET("1")
    Call<Details> getDetails();
}
