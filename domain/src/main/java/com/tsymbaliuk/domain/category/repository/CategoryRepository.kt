package com.tsymbaliuk.domain.category.repository

import com.tsymbaliuk.domain.category.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getAllCategories(): Flow<List<CategoryModel>>

}