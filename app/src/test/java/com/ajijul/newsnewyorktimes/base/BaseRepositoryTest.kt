package com.ajijul.newsnewyorktimes.base

import com.ajijul.newsnewyorktimes.network.ResponseWrapper
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class BaseRepositoryTest {
    private lateinit var repo: BaseRepository

    @Before
    fun setUp() {
        repo = mock(BaseRepository::class.java)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `when lambda returns successfully then it should emit the result as success`() {
        runBlocking {
            val lambdaResult = true
            val result: ResponseWrapper<Boolean> = repo.safeApiCall { lambdaResult }
            assertEquals(ResponseWrapper.Success(lambdaResult), result)
        }
    }

    @Test
    fun `when lambda throws IOException then it should emit the result as NetworkError`() {
        runBlocking {
            val result = repo.safeApiCall{ throw IOException() }
            assertEquals(ResponseWrapper.Error(), result)
        }
    }

    @Test
    fun `when lambda throws HttpException then it should emit the result as GenericError`() {
        val errorBody = "{\"error\": \"Unexpected parameter\"}".toResponseBody("application/json".toMediaTypeOrNull())

        runBlocking {
            val result = repo.safeApiCall {
                throw HttpException(Response.error<Any>(422, errorBody))
            }
            assertEquals(ResponseWrapper.Error(422,"Unexpected parameter"), result)
        }
    }

}