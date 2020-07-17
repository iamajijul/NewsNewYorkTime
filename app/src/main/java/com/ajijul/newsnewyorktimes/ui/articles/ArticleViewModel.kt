package com.ajijul.newsnewyorktimes.ui.articles

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import kotlinx.coroutines.launch

class ArticleViewModel @ViewModelInject constructor(var repository: ArticleRepository) :
    ViewModel() {


    private var allLatestArticle = MutableLiveData<ResponseWrapper<NyNewsFeedBaseModel?>>()

    init {
        getLatestArticles()
    }

    fun observeArticles(): LiveData<ResponseWrapper<NyNewsFeedBaseModel?>> = allLatestArticle

    private fun getLatestArticles() = viewModelScope.launch {
        allLatestArticle.postValue(ResponseWrapper.Loading())
        val response =
            repository.getArticles()
        allLatestArticle.postValue(response)
    }

}