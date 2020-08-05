package com.tsymbaliuk.domain.category.usecase

import com.sun.xml.internal.ws.api.policy.SourceModel
import com.tsymbaliuk.domain.category.model.CategoryModel
import com.tsymbaliuk.domain.category.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryUseCaseImpl(private  val repository: CategoryRepository): CategoryUseCase {

    override fun getAllCategories(): Flow<List<CategoryModel>> = repository.getAllCategories()

}