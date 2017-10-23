package com.example.alejandroorozco.shoppingproducts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alejandroorozco.shoppingproducts.Adapter.ProductsAdapter;
import com.example.alejandroorozco.shoppingproducts.Api.ProductService;
import com.example.alejandroorozco.shoppingproducts.Models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Products extends AppCompatActivity {

    ArrayList<Product> products;
    RecyclerView recyclerView;
    ProductsAdapter productsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);


        recyclerView = (RecyclerView) findViewById(R.id.productsRecyclerview);

        products = new ArrayList<Product>();
        productsAdapter = new ProductsAdapter(products,this);
        recyclerView = (RecyclerView)findViewById(R.id.productsRecyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(productsAdapter);

        Call<ArrayList<Product>> callProducts = ProductService.getProductApi().getProducts();

        callProducts.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {

                products.addAll(response.body());

                productsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
    }
}
