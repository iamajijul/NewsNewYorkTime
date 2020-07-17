package com.ajijul.newsnewyorktimes.di

import android.content.Context
import androidx.room.Room
import com.ajijul.newsnewyorktimes.db.NewYorkTimesDAO
import com.ajijul.newsnewyorktimes.db.NewYorkTimesDatabase
import com.ajijul.newsnewyorktimes.helper.Constant.DATABASE_NAME
import com.ajijul.newsnewyorktimes.ui.articles.ArticleRepository
import com.ajijul.newsnewyorktimes.ui.articles.ArticleRepositoryImpl
import com.ajijul.ny.gateway.network.NewYorkTimeAPIEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideArticleDatabase(@ApplicationContext context: Context): NewYorkTimesDatabase =
        Room.databaseBuilder(context, NewYorkTimesDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()// if I change the database version, old version will
            // remove from device and a new version will create.
            .build()


    @Singleton
    @Provides
    fun provideArticleDao(db: NewYorkTimesDatabase) = db.getNewYorkTimesDao()

    @Singleton
    @Provides
    fun provideNewsRepository(
        api: NewYorkTimeAPIEndPoint,
        dao: NewYorkTimesDAO
    ): ArticleRepository =
        ArticleRepositoryImpl(dao = dao, apiEndPoint = api)

}