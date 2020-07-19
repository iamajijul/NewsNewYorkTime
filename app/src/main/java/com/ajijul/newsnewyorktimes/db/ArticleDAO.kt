package com.ajijul.newsnewyorktimes.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ajijul.ny.news_feed.model.Result

@Dao
interface ArticleDAO {

    @Transaction
    suspend fun insertOrUpdateArticles(articles: List<Result>) {
        deleteAllArticles()
        insertAllArticles(articles)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllArticles(articles: List<Result>)


    @Query("DELETE FROM new_york_time")
    suspend fun deleteAllArticles()

    @Query("SELECT * FROM new_york_time")
    fun getAllArticles(): LiveData<List<Result>>


}