package com.tsymbaliuk.domain.category.usecase

import com.sun.xml.internal.ws.api.policy.SourceModel
import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.category.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {

    fun getAllCategories(): Flow<List<CategoryModel>>

   /* fun getNewsByCategory(categoryName: String): Flow<List<CategoryWithNewsModel>>

    fun cacheNewsByCategory()

    fun getCacheNewsByCategory(): Flow<List<ArticleModel>>

    fun updateCacheNewsByCategory(newCache: List<ArticleModel>): Flow<List<ArticleModel>>*/

}