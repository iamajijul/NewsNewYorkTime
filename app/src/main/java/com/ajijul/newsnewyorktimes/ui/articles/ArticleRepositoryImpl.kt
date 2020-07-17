package com.ajijul.newsnewyorktimes.ui.articles

import com.ajijul.newsnewyorktimes.base.BaseRepository
import com.ajijul.newsnewyorktimes.db.NewYorkTimesDAO
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.ny.gateway.network.NewYorkTimeAPIEndPoint
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    var apiEndPoint: NewYorkTimeAPIEndPoint,
    var dao: NewYorkTimesDAO
) : BaseRepository(), ArticleRepository {
    override suspend fun getArticles(): ResponseWrapper<NyNewsFeedBaseModel?> {
        return safeApiCall {
            apiEndPoint.getArticles().body()
        }
    }


}