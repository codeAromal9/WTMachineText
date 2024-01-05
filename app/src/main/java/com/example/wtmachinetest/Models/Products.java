package com.example.wtmachinetest.Models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "products_table")
public class Products{

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private Integer id;

    @ColumnInfo
    @SerializedName("title")
    @Expose
    private String title;
    @ColumnInfo
    @SerializedName("price")
    @Expose
    private Double price;
    @ColumnInfo
    @SerializedName("description")
    @Expose
    private String description;
    @ColumnInfo
    @SerializedName("category")
    @Expose
    private String category;
    @ColumnInfo
    @SerializedName("image")
    @Expose
    private String image;

    @TypeConverters(ConvertRating.class)
    @ColumnInfo
    @SerializedName("rating")
    @Expose
    public Rating rating;

    public Products(Integer id, String title, Double price, String description, String category, String image, Rating rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }

}
