package com.example.alejandroorozco.shoppingproducts.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alejandroorozcobuiles on 9/09/17.
 */

public class ProductService {

    public static ProductRepository getProductApi(){

        return new Retrofit.Builder()
                .baseUrl(ProductRepository.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductRepository.class);


    }
}
