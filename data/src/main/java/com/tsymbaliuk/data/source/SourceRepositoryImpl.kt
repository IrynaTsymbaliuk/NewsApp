package com.tsymbaliuk.data.source

import com.tsymbaliuk.data.conversions.toSourceModelList
import com.tsymbaliuk.data.retrofit.NetworkContract
import com.tsymbaliuk.domain.source.model.SourceModel
import com.tsymbaliuk.domain.source.repository.SourceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SourceRepositoryImpl(private val api: SourceApi): SourceRepository {

    override fun getAllSources(): Flow<List<SourceModel>> =
        flow { emit(api.getAllSource(NetworkContract.KEY).toSourceModelList()) }

}