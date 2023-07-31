package com.example.mvvm_newsapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_newsapp.data.model.Article
import com.example.mvvm_newsapp.domain.use_case.GetNewsUseCase
import com.example.mvvm_newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {

    val articles = mutableStateOf(HomeStateHolder())

    init {
        getNews()
    }

    fun getNews() {
        getNewsUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    articles.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    articles.value = HomeStateHolder(data = it.data)
                    Log.d("Data:", " ${it.data}")
                }
                is Resource.Error -> {
                    articles.value = HomeStateHolder(error = it.message.toString())
                }
            }

        }.launchIn(viewModelScope)
    }


}

data class HomeStateHolder(
    val isLoading: Boolean = false,
    val data: List<Article>? = null,
    val error: String = "",
)