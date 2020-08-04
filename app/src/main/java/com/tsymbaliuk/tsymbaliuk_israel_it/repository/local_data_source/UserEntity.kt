package com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity (
    @PrimaryKey
    var email: String = "",
    var phoneNumber: String? = null,
    var passwordHash: String? = null
)