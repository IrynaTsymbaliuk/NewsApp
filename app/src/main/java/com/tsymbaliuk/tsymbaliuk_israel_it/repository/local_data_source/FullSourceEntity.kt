package com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FullSourceEntity(
    @PrimaryKey
    var name: String = "",
    var description: String? = null,
    var url: String? = null,
    var category: String? = null,
    var language: String? = null,
    var country: String? = null,
    var isSubscribed: Boolean = false
)