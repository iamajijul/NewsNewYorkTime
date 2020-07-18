package com.ajijul.newsnewyorktimes.ui.articles

import com.ajijul.newsnewyorktimes.base.BaseRepository
import com.ajijul.newsnewyorktimes.db.NewYorkTimesDAO
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.newsnewyorktimes.network.NewYorkTimeAPIEndPoint
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import com.ajijul.ny.news_feed.model.Result
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

    override suspend fun insertArticlesIntoDataBase(data: List<Result>) {

        dao.insertOrUpdateArticles(data)
    }

    override suspend fun getAllArticlesFromDataBase(): List<Result> {

        return dao.getAllArticles()

    }


}