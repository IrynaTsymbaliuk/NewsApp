package com.tsymbaliuk.domain.source.repository

import com.tsymbaliuk.domain.source.model.SourceModel
import kotlinx.coroutines.flow.Flow

interface SourceRepository {

    fun getAllSources(): Flow<List<SourceModel>>

}