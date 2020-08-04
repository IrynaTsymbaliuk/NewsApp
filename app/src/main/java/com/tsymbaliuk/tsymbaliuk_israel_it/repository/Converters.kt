package com.tsymbaliuk.tsymbaliuk_israel_it.repository

import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.ArticleEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.CategoryEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.FullSourceEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.CategoryModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.SourceModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source.NewsResponse
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source.SourceResponse

fun NewsResponse.toArticleModelList(): List<ArticleModel> {
    val articleModelList = arrayListOf<ArticleModel>()
    if (articles != null) {
        articles!!.forEach { article ->
            articleModelList.add(
                ArticleModel(
                    article.urlToImage ?: "",
                    article.source?.name ?: "",
                    article.title ?: "",
                    article.publishedAt ?: ""
                )
            )
        }
    }
    return articleModelList
}

fun ArticleEntity.toArticleModel(): ArticleModel {
    return ArticleModel(urlToImage?:"", source?.name?:author, title, publishedAt?:"")
}

fun CategoryEntity.toCategoryModel(): CategoryModel {
    return CategoryModel(
        categoryName
    )
}

fun FullSourceEntity.toSourceModel(): SourceModel {
    return SourceModel(
        name,
        description,
        url,
        false
    )
}

fun SourceResponse.toSourceModelList(): List<SourceModel> {
    val sourceModelList = arrayListOf<SourceModel>()
    if (sources != null) {
        sources!!.forEach { source ->
            sourceModelList.add(
                SourceModel(
                    source.name, source.description, source.url, false
                )
            )
        }
    }
    return sourceModelList
}