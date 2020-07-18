package com.ajijul.newsnewyorktimes.ui.articles

import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import com.ajijul.ny.news_feed.model.Result

interface ArticleRepository {

    suspend fun getArticles(): ResponseWrapper<NyNewsFeedBaseModel?>
    suspend fun insertArticlesIntoDataBase(data: List<Result>)
    suspend fun getAllArticlesFromDataBase(): List<Result>


}