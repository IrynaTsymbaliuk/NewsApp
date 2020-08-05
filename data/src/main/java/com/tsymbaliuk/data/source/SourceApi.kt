package com.tsymbaliuk.data.source

import com.tsymbaliuk.data.retrofit.NetworkContract
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApi {

    @GET(NetworkContract.SOURCES)
    suspend fun getAllSource(
        @Query("apiKey") apiKey: String
    ): SourceResponse

}