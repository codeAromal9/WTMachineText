package com.example.wtmachinetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.wtmachinetest.Adapter.ProductsAdapter;
import com.example.wtmachinetest.Api.ApiClient;
import com.example.wtmachinetest.Models.Products;
import com.example.wtmachinetest.RoomDB.ProductsRepository;
import com.example.wtmachinetest.RoomDB.ProductsViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ProductsAdapter.OnItemClickListener {

    private ProductsViewModel productsViewModel;
    private List<Products> getProducts;
    private ProductsAdapter productsAdapter;
    RecyclerView productRV_1;
    private ProductsRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = new ProductsRepository(getApplication());
        getProducts = new ArrayList<>();
        productRV_1 = findViewById(R.id.productRV_1);

        productRV_1.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        productRV_1.setLayoutManager(layoutManager);

        productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);

        productsAdapter = new ProductsAdapter(MainActivity.this, new DiffUtil.ItemCallback<Products>() {
            @Override
            public boolean areItemsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
                return oldItem.equals(newItem);
            }
        });

        getListData();
        productsAdapter.setOnItemClickListener(this);

        repository.getAllProducts().observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
//                System.out.println("DATA::-> onChanged\n"+products);
                productRV_1.setAdapter(productsAdapter);
                productsAdapter.setAllDatas(products);
            }
        });
    }

    private void getListData() {

        ApiClient.getClient().getProductList().enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if (response.isSuccessful()){
                    repository.insert(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.d("main", "onFailure: "+t.getMessage());
            }
        });
    }

    @Override
    public void onItemClick(Products product) {
//        System.out.println("DATA::-> onItemClick" +product);
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
//        intent.putExtra("ProductList",product.getId());
        startActivity(intent);
    }
}