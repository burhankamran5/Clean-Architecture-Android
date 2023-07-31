package com.example.mvvm_newsapp.data.network
import com.example.mvvm_newsapp.constants.Constants
import com.example.mvvm_newsapp.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("country") country:String="us",
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<NewsDTO>
}