package com.tsymbaliuk.data.conversions

import com.tsymbaliuk.data.article.ArticleResponse
import com.tsymbaliuk.data.category.CategoryEnum
import com.tsymbaliuk.data.source.SourceResponse
import com.tsymbaliuk.data.user.UserArticleEntity
import com.tsymbaliuk.data.user.UserCategoryEntity
import com.tsymbaliuk.data.user.UserSourceEntity
import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.category.model.CategoryModel
import com.tsymbaliuk.domain.source.model.SourceModel

fun ArticleResponse.toArticleModelList(): List<ArticleModel> {
    val articleModelList = arrayListOf<ArticleModel>()
    if (articles != null) {
        articles!!.forEach { article ->
            articleModelList.add(
                ArticleModel(
                    article.urlToImage ?: "",
                    article.articleSource?.name ?: "",
                    article.title ?: "",
                    article.publishedAt ?: ""
                )
            )
        }
    }
    return articleModelList
}

fun UserArticleEntity.toArticleModel(): ArticleModel {
    return ArticleModel(urlToImage?:"", articleSource?.name?:author, title, publishedAt?:"")
}

fun UserCategoryEntity.toCategoryModel(): CategoryModel {
    return CategoryModel(
        categoryName
    )
}

fun UserSourceEntity.toSourceModel(): SourceModel {
    return SourceModel(
        name,
        description?: "",
        url?:""
    )
}

fun SourceResponse.toSourceModelList(): List<SourceModel> {
    val sourceModelList = arrayListOf<SourceModel>()
    if (sources != null) {
        sources!!.forEach { source ->
            sourceModelList.add(
                SourceModel(
                    source.name?:"", source.description?:"", source.url?:""
                )
            )
        }
    }
    return sourceModelList
}

fun CategoryEnum.toCategoryModel(): CategoryModel = CategoryModel(name)