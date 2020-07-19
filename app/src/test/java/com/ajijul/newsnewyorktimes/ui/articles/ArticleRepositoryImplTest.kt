package com.ajijul.newsnewyorktimes.ui.articles

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.ajijul.newsnewyorktimes.db.ArticleDAO
import com.ajijul.newsnewyorktimes.db.ArticleDatabase
import com.ajijul.newsnewyorktimes.helper.TestUtils
import com.ajijul.newsnewyorktimes.network.NewYorkTimeAPIEndPoint
import com.ajijul.ny.news_feed.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class ArticleRepositoryImplTest {

    private lateinit var dao: ArticleDAO
    private lateinit var api: NewYorkTimeAPIEndPoint
    private lateinit var db: ArticleDatabase
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setUp() {

        val context = mock(Context::class.java)
        db = Room.inMemoryDatabaseBuilder(
            context, ArticleDatabase::class.java
        ).build()
        dao = db.getNewYorkTimesDao()
    }

    /*This method testing all database related manipulation used in this project*/
    @Test
    @Throws(Exception::class)
    fun insertArticlesIntoDataBase() = testDispatcher.runBlockingTest {
        val articles: List<Result> = TestUtils.createTestArticle()
        testScope.launch(Dispatchers.IO) {

            dao.insertOrUpdateArticles(articles)
            val fetchArticles: LiveData<List<Result>> = dao.getAllArticles()
            assertThat(fetchArticles.value?.size, equalTo(articles.size))
        }
    }
}


