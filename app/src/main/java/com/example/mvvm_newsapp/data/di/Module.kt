// File: NewsRepositoryModule.kt

package com.example.mvvm_newsapp.data.di

import com.example.mvvm_newsapp.data.repository.NewsRepoImpl
import com.example.mvvm_newsapp.data.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class NewsRepositoryModule {

    @Binds
    abstract fun bindNewsRepository(newsRepoImpl: NewsRepoImpl): NewsRepository

}
