package com.ajijul.newsnewyorktimes.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ajijul.ny.news_feed.model.Result

@Dao
interface NewYorkTimesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Result)

    @Delete
    suspend fun deleteArticle(article: Result)

    @Query(
        "SELECT * from new_york_time"
    )
     fun getOfflineArticles() : LiveData<List<Result>>

}