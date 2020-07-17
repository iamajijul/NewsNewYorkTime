package com.ajijul.newsnewyorktimes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.ajijul.ny.news_feed.model.Result

@Database(entities = [Result::class], version = 1)
@TypeConverters(Converters::class)
abstract class NewYorkTimesDatabase : RoomDatabase(){

    abstract fun getNewYorkTimesDao(): NewYorkTimesDAO
}