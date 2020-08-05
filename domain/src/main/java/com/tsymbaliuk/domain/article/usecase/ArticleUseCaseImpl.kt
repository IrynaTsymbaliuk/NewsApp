package com.tsymbaliuk.domain.article.usecase

import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.article.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow

class ArticleUseCaseImpl(private val repository: ArticleRepository): ArticleUseCase {

    override fun getCovidNews(): Flow<List<ArticleModel>> = repository.getTopWithKeyWordInTitle("Covid")

    override fun getTopUaNews(): Flow<List<ArticleModel>> = repository.getTopByCountry("ua")

    override fun getNewsByCategory(categoryName: String): Flow<List<ArticleModel>> = repository.getTopByCategory(categoryName)

    override fun getNewsBySource(sourceName: String): Flow<List<ArticleModel>> = repository.getTopBySource(sourceName)

}