package com.example.mvvm_newsapp.domain.use_case

import android.util.Log
import com.example.mvvm_newsapp.data.model.Article
import com.example.mvvm_newsapp.data.repository.NewsRepository
import com.example.mvvm_newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {

        emit(Resource.Loading(""))
        try {
            emit(Resource.Success(newsRepository.getAllNews()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }

    }

}