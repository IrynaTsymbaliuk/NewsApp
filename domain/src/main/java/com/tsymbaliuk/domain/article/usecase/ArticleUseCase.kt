package com.tsymbaliuk.domain.article.usecase

import com.tsymbaliuk.domain.article.model.ArticleModel
import kotlinx.coroutines.flow.Flow

interface ArticleUseCase {

    fun getCovidNews(): Flow<List<ArticleModel>>

    fun getTopUaNews(): Flow<List<ArticleModel>>

    fun getNewsByCategory(categoryName: String): Flow<List<ArticleModel>>

    fun getNewsBySource(sourceName: String): Flow<List<ArticleModel>>

  /*  fun cacheTopUaNews()

    fun getCacheTopUaNews(): Flow<List<ArticleModel>>

    fun updateCacheTopUaNews(newCache: List<ArticleModel>): Flow<List<ArticleModel>>

    fun getCacheNews(): Flow<List<ArticleModel>>

    fun updateCacheNews(newCache: List<ArticleModel>): Flow<List<ArticleModel>>*/

}