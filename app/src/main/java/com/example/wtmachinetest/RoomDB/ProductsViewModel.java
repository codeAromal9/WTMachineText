package com.example.wtmachinetest.RoomDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wtmachinetest.Api.ApiClient;
import com.example.wtmachinetest.Models.Products;

import java.util.List;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsViewModel extends AndroidViewModel {

    private ProductsRepository repository;
    private LiveData<List<Products>> allProducts;

    public LiveData<List<Products>> getProductList() {

        System.out.println("FUN CALL");

        MutableLiveData<List<Products>> data = new MutableLiveData<>();

        ApiClient.getClient().getProductList().enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.d("YourRepository", "onFailure: " + t.getMessage());
            }
        });

        return data;
    }


    public ProductsViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductsRepository(application);
        allProducts = repository.getAllProducts();
    }

    public void insert(List<Products> products){
        repository.insert(products);
    }

    public LiveData<List<Products>> getAllProducts(){
        return allProducts;
    }
}
