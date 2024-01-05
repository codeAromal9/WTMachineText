package com.example.wtmachinetest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wtmachinetest.Models.Products;
import com.example.wtmachinetest.R;

import java.util.List;

public class ProductsAdapter extends ListAdapter<Products, ProductsAdapter.ProductsViewHolder> {

    private Context mCtx;
    private List<Products> pList;
    private OnItemClickListener listener;

    public ProductsAdapter(Context context, DiffUtil.ItemCallback<Products> diffCallback) {
        super(diffCallback);
        this.mCtx = context;
    }

    @NonNull
    @Override
    public ProductsAdapter.ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_layout, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ProductsViewHolder holder, int position) {
        Products pl = pList.get(position);

        Glide.with(mCtx)
                .load(pl.getImage())
                .into(holder.productImage_1);

        holder.productTitle_1.setText(pl.getTitle());
        String strPrice = Double.toString(pl.getPrice());
        holder.productPrice_1.setText(strPrice);
        holder.productCategory_1.setText(pl.getCategory());
        holder.productRating_1.setText(pl.getRating().getRate().toString());
        String strDlsCount = Integer.toString(pl.getRating().getCount());
        holder.productCount_1.setText(strDlsCount);
        holder.productDescription_1.setText(pl.getDescription());
    }

    @Override
    public int getItemCount() {
        return pList != null ? pList.size() : 0;
    }

    public void setAllDatas(List<Products> products) {
        this.pList = products;
        notifyDataSetChanged();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage_1;
        TextView productTitle_1, productPrice_1, productCategory_1, productRating_1, productCount_1, productDescription_1;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage_1 = itemView.findViewById(R.id.productImage_1);
            productTitle_1 = itemView.findViewById(R.id.productTitle_1);
            productPrice_1 = itemView.findViewById(R.id.productPrice_1);
            productCategory_1 = itemView.findViewById(R.id.productCategory_1);
            productRating_1 = itemView.findViewById(R.id.productRating_1);
            productCount_1 = itemView.findViewById(R.id.productCount_1);
            productDescription_1 = itemView.findViewById(R.id.productDescription_1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && pList != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.onItemClick(pList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Products product);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}

