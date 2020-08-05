package com.tsymbaliuk.domain.source.usecase

import com.tsymbaliuk.domain.source.model.SourceModel
import com.tsymbaliuk.domain.source.repository.SourceRepository
import kotlinx.coroutines.flow.Flow

class SourceUseCaseImpl(private val repository: SourceRepository): SourceUseCase {

    override fun getAllSources(): Flow<List<SourceModel>> = repository.getAllSources()

}