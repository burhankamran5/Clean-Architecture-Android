package com.example.mvvm_newsapp.data.di

import com.example.mvvm_newsapp.constants.Constants
import com.example.mvvm_newsapp.data.network.ApiService
import com.example.mvvm_newsapp.data.repository.NewsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        )
            .build().create(ApiService::class.java)
    }





}