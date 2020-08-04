package com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CategoryEntity (
    @PrimaryKey
    var categoryName: String = ""
)