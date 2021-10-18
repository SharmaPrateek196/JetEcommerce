package com.example.compose_mvvm_clean.data.dto

import com.example.compose_mvvm_clean.domain.model.ProductModel

data class ProductItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

fun ProductItem.toProductModel(): ProductModel {
    return ProductModel(
        category = this.category,
        description = this.description,
        id = this.id,
        image = this.image,
        price = this.price,
        rating = this.rating.toRatingModel(),
        title = this.title
    )
}