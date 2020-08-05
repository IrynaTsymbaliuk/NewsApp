package com.tsymbaliuk.data.article

import com.tsymbaliuk.data.BuildConfig
import com.tsymbaliuk.data.conversions.toArticleModelList
import com.tsymbaliuk.data.retrofit.NetworkContract.COUNTRY
import com.tsymbaliuk.data.retrofit.NetworkContract.KEY
import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.article.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class ArticleRepositoryImpl(private val api: ArticleApi) : ArticleRepository {

    override fun getTopWithKeyWordInTitle(keyword: String): Flow<List<ArticleModel>> =
        flow { emit(api.getNewsWithKeyWord(COUNTRY, keyword, KEY).toArticleModelList()) }

    override fun getTopByCountry(country: String): Flow<List<ArticleModel>> =
        flow { emit(api.getNewsByCountry(COUNTRY, KEY).toArticleModelList())
    }

    override fun getTopBySource(sourceName: String): Flow<List<ArticleModel>> =
        flow { emit(api.getNewsBySource(sourceName, KEY).toArticleModelList()) }

    override fun getTopByCategory(category: String): Flow<List<ArticleModel>> =
        flow { emit(api.getNewsByCategory(COUNTRY, category, KEY).toArticleModelList())
    }
}