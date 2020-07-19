package com.ajijul.newsnewyorktimes.helper

import com.ajijul.ny.news_feed.model.Result

object TestUtils {
    fun createTestArticle(): List<Result> {
        return arrayListOf(
            Result(
                "demoUrl", "demoAdx", "demoSection", "",
                "", "demoTile", "demoAbstract", "", "",
                1.0000, 1.999, 0.0000, ArrayList(), "", ""
            )
        )
    }
}