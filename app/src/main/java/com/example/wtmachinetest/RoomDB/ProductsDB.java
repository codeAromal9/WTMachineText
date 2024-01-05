package com.example.wtmachinetest.RoomDB;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.wtmachinetest.Models.Products;

@Database(entities = {Products.class}, version = 2)
public abstract class ProductsDB extends RoomDatabase {

    private static final String DATABASE_NAME = "Products";
    public abstract ProductsDao productsDao();
    public static ProductsDB instance;

    public static synchronized ProductsDB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ProductsDB.class, "products_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    public static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDBAsyn(instance).execute();
        }
    };
    static class PopulateDBAsyn extends AsyncTask<Void, Void, Void> {
        private ProductsDao productsDao;
        PopulateDBAsyn(ProductsDB instance){

            ProductsDao dao = instance.productsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}
