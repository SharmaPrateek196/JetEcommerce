package com.example.compose_mvvm_clean.data.source.remote.api

import com.example.compose_mvvm_clean.data.dto.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductApis {

    @GET("products")
    suspend fun getProducts(): Response<List<ProductItem>>
}