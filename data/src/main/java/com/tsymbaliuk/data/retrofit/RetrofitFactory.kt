package com.tsymbaliuk.data.retrofit

import retrofit2.Retrofit

interface RetrofitFactory {

    fun createRetrofit(): Retrofit

}