package com.example.compose_mvvm_clean.domain.repository

import com.example.compose_mvvm_clean.data.dto.ProductItem
import com.example.compose_mvvm_clean.data.util.SafeResult

interface IProductRepo {
    suspend fun getRemoteProducts(): SafeResult<List<ProductItem>>
}