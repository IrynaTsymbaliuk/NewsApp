package com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source

import androidx.room.Embedded
import androidx.room.Entity

@Entity(primaryKeys = ["author", "title"])
class ArticleEntity (
    @Embedded
    var source: ShortSource?,
    var author: String = "",
    var title: String = "",
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null
)

@Entity(primaryKeys = ["id", "name"])
data class ShortSource (
    var id: String = "",
    var name: String = ""
)