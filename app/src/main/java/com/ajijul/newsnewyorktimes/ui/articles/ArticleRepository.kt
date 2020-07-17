package com.ajijul.newsnewyorktimes.ui.articles

import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel

interface ArticleRepository {

    suspend fun getArticles() : ResponseWrapper<NyNewsFeedBaseModel?>


}