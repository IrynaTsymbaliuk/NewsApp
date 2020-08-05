package com.tsymbaliuk.data.article

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleResponse (
    var status: String?,
    var totalResults: Int?,
    var articles: List<Article>?
): Parcelable

@Parcelize
data class Article (
    var articleSource: ArticleSource?,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
): Parcelable

@Parcelize
data class ArticleSource (
    var id: String?,
    var name: String?
): Parcelable