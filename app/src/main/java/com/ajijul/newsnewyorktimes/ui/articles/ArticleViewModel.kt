package com.ajijul.newsnewyorktimes.ui.articles

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.ajijul.newsnewyorktimes.base.BaseViewModel
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import com.ajijul.ny.news_feed.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleViewModel @ViewModelInject constructor(private var repository: ArticleRepository) :
    BaseViewModel() {


    private var allLatestArticle = MutableLiveData<List<Result>>()

    fun observeArticlesOffline(): LiveData<List<Result>> {
        viewModelScope.launch(Dispatchers.IO) {
            allLatestArticle.postValue(repository.getAllArticlesFromDataBase())
        }
        return allLatestArticle
    }

    fun observeArticlesOnline() = liveData(Dispatchers.IO) {
        emit(ResponseWrapper.Loading())
        repository.getArticles().let {
            emit(it)
            when (it) {
                is ResponseWrapper.Success -> {
                    it.data?.results?.let {
                        repository.insertArticlesIntoDataBase(it)
                    }
                }
                else -> {
                }
            }

        }

    }

}