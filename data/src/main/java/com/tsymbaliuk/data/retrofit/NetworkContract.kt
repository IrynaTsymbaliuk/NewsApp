package com.tsymbaliuk.data.retrofit

import com.tsymbaliuk.data.BuildConfig

object NetworkContract {

    const val BASE_URL = "https://newsapi.org/"

    val KEY = BuildConfig.NEWSAPI_KEY

    const val COUNTRY = "ua"

    const val ARTICLES = "v2/top-headlines"
    const val SOURCES = "v2/sources"

}