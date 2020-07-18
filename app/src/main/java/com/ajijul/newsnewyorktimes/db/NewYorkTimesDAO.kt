package com.ajijul.newsnewyorktimes.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ajijul.ny.news_feed.model.Result

@Dao
interface NewYorkTimesDAO {

    @Transaction
    fun insertOrUpdateArticles(articles: List<Result>) {
        deleteAllArticles()
        insertAllArticles(articles)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllArticles(articles: List<Result>)

    @Query("DELETE FROM new_york_time")
    fun deleteAllArticles()

    @Query("SELECT * FROM new_york_time")
    fun getAllArticles(): List<Result>


}