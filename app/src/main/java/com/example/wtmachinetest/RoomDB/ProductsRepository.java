package com.example.wtmachinetest.RoomDB;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.wtmachinetest.Models.Products;

import java.util.List;

public class ProductsRepository {

    public ProductsDao productsDao;
    private LiveData<List<Products>> allProducts;
    private ProductsDB database;

    public ProductsRepository(Application application){
        ProductsDB database = ProductsDB.getInstance(application);
        productsDao = database.productsDao();
        allProducts = productsDao.getAllProducts();
    }

    public void insert(List<Products> products){
        new InsertProductsAsyncTask(productsDao).execute(products);
    }



    public LiveData<List<Products>> getAllProducts(){
        return allProducts;
    }

    private static class InsertProductsAsyncTask extends AsyncTask<List<Products>, Void, Void>{
        private ProductsDao productsDao;

        public InsertProductsAsyncTask(ProductsDao productsDao){
            this.productsDao = productsDao;
        }

        @Override
        protected Void doInBackground(List<Products>... lists) {
            productsDao.insert(lists[0]);
            return null;
        }
    }

}
