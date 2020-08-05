package com.tsymbaliuk.domain.source.usecase

import com.tsymbaliuk.domain.source.model.SourceModel
import kotlinx.coroutines.flow.Flow

interface SourceUseCase {

    fun getAllSources(): Flow<List<SourceModel>>

}