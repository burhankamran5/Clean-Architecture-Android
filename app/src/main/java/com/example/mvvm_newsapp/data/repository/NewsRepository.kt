package com.example.mvvm_newsapp.data.repository

import com.example.mvvm_newsapp.data.model.Article


interface NewsRepository {
    suspend fun getAllNews(): List<Article>
}
