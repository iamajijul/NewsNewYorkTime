package com.ajijul.newsnewyorktimes.ui.articles

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.ajijul.newsnewyorktimes.base.BaseViewModel
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import com.ajijul.ny.news_feed.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class ArticleViewModel @ViewModelInject constructor(private var repository: ArticleRepository) :
    BaseViewModel() {


    private var retryRequest = MutableLiveData<Boolean>()

    fun observeArticlesOffline(): LiveData<List<Result>> = repository.getAllArticlesFromDataBase()

    init {
        retryRequest.value = true
    }

    fun observeArticlesOnline(): LiveData<ResponseWrapper<NyNewsFeedBaseModel?>> =
        retryRequest.switchMap { status ->
                articles

        }

    var articles: LiveData<ResponseWrapper<NyNewsFeedBaseModel?>> = liveData(Dispatchers.IO) {
        emit(ResponseWrapper.Loading())
        repository.getArticles().let {
            emit(it)
            when (it) {
                is ResponseWrapper.Success -> {
                    it.data?.results?.map {
                        result ->
                        result.mediaImageUrl = result.media?.get(0)?.mediaMetadata?.get(2)?.url
                        result
                    }?.let {
                        repository.insertArticlesIntoDataBase(it)
                    }
                }
                else -> {
                }
            }

        }
    }

    fun retryToFetchedArticle(status: Boolean) {
        retryRequest.value = status
    }

}

