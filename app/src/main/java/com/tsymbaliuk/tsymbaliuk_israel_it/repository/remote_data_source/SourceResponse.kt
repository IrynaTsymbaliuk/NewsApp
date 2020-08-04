package com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SourceResponse (
    var status: String?,
    var sources: List<Source>?
): Parcelable

@Parcelize
data class Source (
    var id: String?,
    var name: String?,
    var description: String?,
    var url: String?,
    var category: String?,
    var language: String?,
    var country: String?
): Parcelable