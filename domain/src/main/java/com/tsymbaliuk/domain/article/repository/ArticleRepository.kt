package com.tsymbaliuk.domain.article.repository

import com.tsymbaliuk.domain.article.model.ArticleModel
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun getTopWithKeyWordInTitle(keyword: String): Flow<List<ArticleModel>>

    fun getTopByCountry(country: String): Flow<List<ArticleModel>>

    fun getTopBySource(sourceName: String): Flow<List<ArticleModel>>

    fun getTopByCategory(category: String): Flow<List<ArticleModel>>

}