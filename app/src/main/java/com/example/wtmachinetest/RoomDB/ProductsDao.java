package com.example.wtmachinetest.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wtmachinetest.Models.Products;

import java.util.List;

@Dao
public interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Products> products);

    @Update
    void update(Products model);

    @Delete
    void delete(Products products);

    @Query("SELECT * FROM products_table")
    LiveData<List<Products>> getAllProducts();

    @Query("DELETE FROM products_table")
    void deleteAllProducts();


}
