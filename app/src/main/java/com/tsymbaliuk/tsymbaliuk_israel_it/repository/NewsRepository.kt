package com.tsymbaliuk.tsymbaliuk_israel_it.repository

import androidx.lifecycle.LiveData
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.SourceModel

interface NewsRepository {

    fun getNewsWithKeyWord(keyword: String): LiveData<List<ArticleModel>>

    fun getNewsByCountry(country: String): LiveData<List<ArticleModel>>

    fun getAllSource(): LiveData<List<SourceModel>>

    fun getNewsByCategory(category: String): LiveData<List<ArticleModel>>

    fun getNewsBySource(sourceName: String): LiveData<List<ArticleModel>>

}