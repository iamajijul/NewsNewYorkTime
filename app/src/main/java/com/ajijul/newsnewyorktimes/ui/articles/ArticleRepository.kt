package com.ajijul.newsnewyorktimes.ui.articles

import androidx.lifecycle.LiveData
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import com.ajijul.ny.news_feed.model.Result

interface ArticleRepository {

    suspend fun getArticles(): ResponseWrapper<NyNewsFeedBaseModel?>
    suspend fun insertArticlesIntoDataBase(data: List<Result>)
    fun getAllArticlesFromDataBase(): LiveData<List<Result>>


}