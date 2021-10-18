package com.example.compose_mvvm_clean.di.modules

import com.example.compose_mvvm_clean.data.source.remote.api.ProductApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class ApiModule {

    @Provides
    @ActivityRetainedScoped
    fun provideProductApi(
        retrofit: Retrofit
    ): ProductApis {
        return retrofit.create(ProductApis::class.java)
    }
}