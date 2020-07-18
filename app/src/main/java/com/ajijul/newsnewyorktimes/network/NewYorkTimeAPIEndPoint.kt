package com.ajijul.newsnewyorktimes.network

import com.ajijul.newsnewyorktimes.helper.Constant.API_KEY
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NewYorkTimeAPIEndPoint {

    @GET("viewed/{period}.json")
    suspend fun getArticles(
        @Path("period") period: String = "7",
        @Query("api-key") apiKey: String = API_KEY
    ): Response<NyNewsFeedBaseModel>
}