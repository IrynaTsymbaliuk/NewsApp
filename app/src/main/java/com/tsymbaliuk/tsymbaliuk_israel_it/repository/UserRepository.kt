package com.tsymbaliuk.tsymbaliuk_israel_it.repository

import androidx.lifecycle.LiveData
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.CategoryModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.SourceModel

interface UserRepository {

    fun logIn()

    fun logOut()

    fun getCategorySubscriptions(): LiveData<List<CategoryModel>>

    fun removeFromCategorySubscriptions(categoryName: String)

    suspend fun addToSourceSubscriptions(name: String, description: String, url: String)

    fun getSourceSubscriptions(): LiveData<List<SourceModel>>

    fun removeFromSourceSubscriptions(sourceName: String)

    suspend fun saveArticle()

    fun getSavedArticles(): LiveData<List<ArticleModel>>

    fun deleteArticle()

    suspend fun addToCategorySubscriptions(categoryName: String)

    fun signUp(email: String, phoneNumber: String, passwordHash: String)
}