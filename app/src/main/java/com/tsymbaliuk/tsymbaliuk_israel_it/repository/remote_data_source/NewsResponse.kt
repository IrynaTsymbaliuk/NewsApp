package com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponse (
    var status: String?,
    var totalResults: Int?,
    var articles: List<Article>?
): Parcelable

@Parcelize
data class Article (
    var source: NewsSource?,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
): Parcelable

@Parcelize
data class NewsSource (
    var id: String?,
    var name: String?
): Parcelable