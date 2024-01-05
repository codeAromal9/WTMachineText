package com.example.wtmachinetest.Models;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class ConvertRating {

    @TypeConverter
    public static Rating fromString(String value) {
        return new Gson().fromJson(value, Rating.class);
    }

    @TypeConverter
    public static String fromRating(Rating rating) {
        return new Gson().toJson(rating);
    }
}
