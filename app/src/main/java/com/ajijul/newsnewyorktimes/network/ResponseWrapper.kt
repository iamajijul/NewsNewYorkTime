package com.ajijul.newsnewyorktimes.network

sealed class ResponseWrapper<out T> {

    data class Success<T>(
        val data: T? = null,
        val message: String? = null

    ) : ResponseWrapper<T>()

    data class Error(
        var message: String? = null,
        var code: Int? = null
    ) : ResponseWrapper<Nothing>()

    class Loading : ResponseWrapper<Nothing>()

}