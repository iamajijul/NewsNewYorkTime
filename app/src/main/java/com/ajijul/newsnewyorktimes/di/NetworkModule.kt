package com.ajijul.newsnewyorktimes.di

import com.ajijul.newsnewyorktimes.helper.Constant.BASE_URL
import com.ajijul.ny.gateway.network.NewYorkTimeAPIEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetroInstance(
        gsonConverterFactory: GsonConverterFactory,
        httpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()


    @Singleton
    @Provides
    fun provideLoggingIntercepter(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Singleton
    @Provides
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    @Singleton
    @Provides
    fun provideGSONConverter() =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideNewYorkTimeAPIEndPoint(retrofit: Retrofit) =
        retrofit.create(NewYorkTimeAPIEndPoint::class.java)
}