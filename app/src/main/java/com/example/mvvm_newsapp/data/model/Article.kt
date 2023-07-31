package com.example.mvvm_newsapp.data.model

data class Article(
    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String
)

fun List<ArticleDTO>.toDomain(): List<Article> {
    return map {
        Article(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            urlToImage = it.urlToImage?:""
        )
    }
}

