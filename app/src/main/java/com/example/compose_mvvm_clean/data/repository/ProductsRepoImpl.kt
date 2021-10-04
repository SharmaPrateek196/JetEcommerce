package com.example.compose_mvvm_clean.data.repository

import com.example.compose_mvvm_clean.data.dto.ProductItem
import com.example.compose_mvvm_clean.data.source.remote.api.ProductApis
import com.example.compose_mvvm_clean.data.util.SafeResult
import com.example.compose_mvvm_clean.data.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class ProductsRepoImpl(
    private val productApis: ProductApis,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) {

    suspend fun getRemoteProducts(): SafeResult<List<ProductItem>> {
        return safeApiCall(coroutineContext) {
            productApis.getProducts()
        }
    }
}