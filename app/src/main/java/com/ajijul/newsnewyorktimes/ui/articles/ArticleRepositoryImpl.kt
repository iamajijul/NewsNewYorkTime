package com.ajijul.newsnewyorktimes.ui.articles

import androidx.lifecycle.LiveData
import com.ajijul.newsnewyorktimes.base.BaseRepository
import com.ajijul.newsnewyorktimes.db.ArticleDAO
import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import com.ajijul.newsnewyorktimes.network.NewYorkTimeAPIEndPoint
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import com.ajijul.ny.news_feed.model.Result
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    var apiEndPoint: NewYorkTimeAPIEndPoint,
    var dao: ArticleDAO
) : BaseRepository(), ArticleRepository {
    override suspend fun getArticles(): ResponseWrapper<NyNewsFeedBaseModel?> {
        return safeApiCall {
            apiEndPoint.getArticles().body()
        }
    }

    override suspend fun insertArticlesIntoDataBase(data: List<Result>) {

        dao.insertOrUpdateArticles(data)
    }

    override  fun getAllArticlesFromDataBase():LiveData< List<Result>> {

        return dao.getAllArticles()

    }


}