package com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source

import androidx.lifecycle.LiveData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://newsapi.org/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

object NewsApi {
    val retrofitService: NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsWithKeyWord(
        @Query("country") country: String,
        @Query("q") keyWord: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("v2/top-headlines")
    suspend fun getNewsByCountry(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("v2/top-headlines")
    suspend fun getNewsByCategory(
        @Query("country") country: String,
        @Query("category") keyWord: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("v2/top-headlines")
    suspend fun getNewsBySource(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("v2/sources")
    suspend fun getAllSource(
        @Query("apiKey") apiKey: String
    ): SourceResponse

}
