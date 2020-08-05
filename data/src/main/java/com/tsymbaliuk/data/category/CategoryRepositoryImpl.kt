package com.tsymbaliuk.data.category

import com.tsymbaliuk.data.category.CategoryEnum.*
import com.tsymbaliuk.data.conversions.toCategoryModel
import com.tsymbaliuk.domain.category.model.CategoryModel
import com.tsymbaliuk.domain.category.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryRepositoryImpl: CategoryRepository {

    override fun getAllCategories(): Flow<List<CategoryModel>> = flow { emit(listOf<CategoryEnum>(
        BUSINESS, ENTERTAINMENT,
        GENERAL, HEALTH, SCIENCE, SPORTS,
        TECHNOLOGY
    ).map { it.toCategoryModel() }) }

}