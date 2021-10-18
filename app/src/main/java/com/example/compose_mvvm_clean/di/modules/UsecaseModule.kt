package com.example.compose_mvvm_clean.di.modules

import com.example.compose_mvvm_clean.domain.repository.IProductRepo
import com.example.compose_mvvm_clean.domain.usecases.GetProductsUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityComponent::class)
class UsecaseModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGetProductsUsecase(productRepo: IProductRepo): GetProductsUsecase {
        return GetProductsUsecase(productRepo)
    }
}