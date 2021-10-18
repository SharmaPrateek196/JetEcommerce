package com.example.compose_mvvm_clean.data.dto

import com.example.compose_mvvm_clean.domain.model.RatingModel

data class Rating(
    val count: Int,
    val rate: Double
)

fun Rating.toRatingModel(): RatingModel {
    return RatingModel(
        count = this.count,
        rate = this.rate
    )
}