package com.example.mvvm_newsapp.data.repository
import com.example.mvvm_newsapp.data.model.Article
import com.example.mvvm_newsapp.data.model.toDomain
import com.example.mvvm_newsapp.data.network.ApiService
import com.example.mvvm_newsapp.utils.SafeApiRequest
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(private val apiService: ApiService) : NewsRepository,
    SafeApiRequest() {
    override suspend fun getAllNews(): List<Article> {

        val response = safeApiRequest { apiService.getAllNews() }
        return response.articles.toDomain()

    }
}