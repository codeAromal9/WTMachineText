package com.example.wtmachinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wtmachinetest.Api.DApiClient;
import com.example.wtmachinetest.Models.Details;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    ImageView detailsImage_1;
    TextView productDtlTitle_1, productDtlPrice_1, productDtlCategory_1,
            productDtlRating_1, productDtlCount_1, productDtlDescription_1;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        detailsImage_1 = findViewById(R.id.detailsImage_1);
        productDtlTitle_1 = findViewById(R.id.productDtlTitle_1);
        productDtlPrice_1 = findViewById(R.id.productDtlPrice_1);
        productDtlCategory_1 = findViewById(R.id.productDtlCategory_1);
        productDtlRating_1 = findViewById(R.id.productDtlRating_1);
        productDtlCount_1 = findViewById(R.id.productDtlCount_1);
        productDtlDescription_1 = findViewById(R.id.productDtlDescription_1);


        getListDetails();
    }

    private void getListDetails() {

        DApiClient.getClient().getDetails().enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Details dls = response.body();

                    Glide.with(DetailsActivity.this)
                            .load(dls.getImage())
                            .into(detailsImage_1);

                    productDtlTitle_1.setText(dls.getTitle());
                    String strDlsPrice = Double.toString(dls.getPrice());
                    productDtlPrice_1.setText(strDlsPrice);
                    productDtlCategory_1.setText(dls.getCategory());
                    productDtlRating_1.setText(dls.getRating().getRate().toString());
                    String strDlsCount = Integer.toString(dls.getRating().getCount());
                    productDtlCount_1.setText(strDlsCount);
                    productDtlDescription_1.setText(dls.getDescription());
                }
            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {

            }
        });
    }
}