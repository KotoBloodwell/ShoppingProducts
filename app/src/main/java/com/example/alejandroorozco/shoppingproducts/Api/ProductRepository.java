package com.example.alejandroorozco.shoppingproducts.Api;


import com.example.alejandroorozco.shoppingproducts.Models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by alejandroorozcobuiles on 9/09/17.
 */

public interface ProductRepository {

    String BASE_URL = "https://shoppingproduct.herokuapp.com";

    @GET("products.json")
    Call<ArrayList<Product>> getProducts();

    @GET("products/{idProduct}.json")
    Call<Product> getProduct(@Path("idProduct") int idProduct);

}
