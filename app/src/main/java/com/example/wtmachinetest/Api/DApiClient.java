package com.example.wtmachinetest.Api;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DApiClient {
    private static Retrofit retrofit = null;

    public static ApiInterface getClient(){
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logger).build();

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://fakestoreapi.com/products/")
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                    .client(client)
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
