package com.example.compose_mvvm_clean.domain.usecases

import com.example.compose_mvvm_clean.domain.repository.IProductRepo

class GetProductsUsecase(
    private val productRepo: IProductRepo
) {
    suspend operator fun invoke() {
        productRepo.getRemoteProducts()
    }
}