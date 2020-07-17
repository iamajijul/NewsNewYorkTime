package com.ajijul.newsnewyorktimes.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.ajijul.ny.news_feed.model.Medium
import java.io.ByteArrayOutputStream
import java.io.OutputStream

class Converters {


    @TypeConverter
    fun toImageUrl(listOfMedia: List<Medium>?): String? {
        return listOfMedia?.get(0)?.mediaMetadata?.get(2)?.url
    }

    @TypeConverter
    fun fromImageUrl(imageUrl: String): List<Medium> {
       return ArrayList<Medium>()
    }
}