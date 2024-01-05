package com.example.wtmachinetest.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "rating_table")
public class Rating {

    @ColumnInfo
    @SerializedName("rate")
    @Expose
    private Double rate;
    @ColumnInfo
    @SerializedName("count")
    @Expose
    private Integer count;



    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
