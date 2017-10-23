package com.example.alejandroorozco.shoppingproducts.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alejandroorozco.shoppingproducts.Api.ProductRepository;
import com.example.alejandroorozco.shoppingproducts.Models.Product;
import com.example.alejandroorozco.shoppingproducts.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by alejandro.orozco on 24/09/2017.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    ArrayList<Product> listProducts;
    Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = listProducts.get(position);
        holder.txtProductName.setText(product.getName());
        holder.txtProductValue.setText( "$ " + String.valueOf(product.getPrice()));
        holder.txtProductRemaining.setText(String.valueOf(product.getQuantity()) + " left");
        Picasso.with(context).load(ProductRepository.BASE_URL+ product.getImage_url()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public ProductsAdapter(ArrayList<Product> listProducts, Context context) {
        this.listProducts = listProducts;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductName;
        TextView txtProductValue;
        TextView txtProductRemaining;
        ImageView imgProduct;

        public ViewHolder(View itemView) {
            super(itemView);

            txtProductName = (TextView) itemView.findViewById(R.id.txtProductName);
            txtProductValue = (TextView) itemView.findViewById(R.id.txtProductValue);
            txtProductRemaining = (TextView) itemView.findViewById(R.id.txtProductRemaining);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);

        }
    }
}
