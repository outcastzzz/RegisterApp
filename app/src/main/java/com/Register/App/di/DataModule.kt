package com.Register.App.di

import com.Register.App.data.network.ApiFactory
import com.Register.App.data.network.ApiService
import com.Register.App.data.repository.AppRepositoryImpl
import com.Register.App.domain.AppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindAppRepository(impl: AppRepositoryImpl): AppRepository


    companion object {

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}