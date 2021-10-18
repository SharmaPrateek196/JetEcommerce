package com.example.compose_mvvm_clean

import androidx.lifecycle.ViewModel
import com.example.compose_mvvm_clean.domain.usecases.GetProductsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    getProductsUsecase: GetProductsUsecase
) : ViewModel() {


}