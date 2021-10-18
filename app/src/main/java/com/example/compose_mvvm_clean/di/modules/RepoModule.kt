package com.example.compose_mvvm_clean.di.modules

import com.example.compose_mvvm_clean.data.repository.ProductsRepoImpl
import com.example.compose_mvvm_clean.data.source.remote.api.ProductApis
import com.example.compose_mvvm_clean.domain.repository.IProductRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityComponent::class)
class RepoModule {

    @Provides
    @ActivityRetainedScoped
    fun provideProductRepo(
        productApis: ProductApis
    ): IProductRepo {
        return ProductsRepoImpl(productApis)
    }
}