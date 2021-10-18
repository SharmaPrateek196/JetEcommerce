package com.example.compose_mvvm_clean.domain.model

data class ProductModel(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingModel,
    val title: String
)

data class RatingModel(
    val count: Int,
    val rate: Double
)
