package com.ajijul.ny.news_feed.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "new_york_time")
data class Result(

    @SerializedName("url")
    @PrimaryKey
    @Expose
    @NonNull
    var url: String = "",

    @SerializedName("adx_keywords")
    @Expose
    var adxKeywords: String? = null,

    @SerializedName("section")
    @Expose
    var section: String? = null,

    @SerializedName("byline")
    @Expose
    var byline: String? = null,

    @SerializedName("type")
    @Expose
    var type: String? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("abstract")
    @Expose
    var abstract: String? = null,

    @SerializedName("published_date")
    @Expose
    var publishedDate: String? = null,

    @SerializedName("source")
    @Expose
    var source: String? = null,

    @SerializedName("id")
    @Expose
    var id: Double? = null,

    @SerializedName("asset_id")
    @Expose
    var assetId: Double? = null,

    @SerializedName("views")
    @Expose
    var views: Double? = null,

    @SerializedName("media")
    @Expose
    var media: List<Medium>? = null,

    var mediaImageUrl: String? = null,

    @SerializedName("uri")
    @Expose
    var uri: String? = null)

{

}
