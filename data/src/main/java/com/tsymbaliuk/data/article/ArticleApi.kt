package com.tsymbaliuk.data.article

import androidx.lifecycle.LiveData
import com.tsymbaliuk.data.retrofit.NetworkContract
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {

    @GET(NetworkContract.ARTICLES)
    suspend fun getNewsWithKeyWord(
        @Query("country") country: String,
        @Query("q") keyWord: String,
        @Query("apiKey") apiKey: String
    ): ArticleResponse

    @GET(NetworkContract.ARTICLES)
    suspend fun getNewsByCountry(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): ArticleResponse

    @GET(NetworkContract.ARTICLES)
    suspend fun getNewsByCategory(
        @Query("country") country: String,
        @Query("category") keyWord: String,
        @Query("apiKey") apiKey: String
    ): ArticleResponse

    @GET(NetworkContract.ARTICLES)
    suspend fun getNewsBySource(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): ArticleResponse

}