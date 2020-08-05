package com.tsymbaliuk.domain.user.usecase

import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.category.model.CategoryModel
import com.tsymbaliuk.domain.source.model.SourceModel
import com.tsymbaliuk.domain.user.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserUseCase {

    fun signUp(user: UserModel)

    fun signIn()

    fun signOut()

    fun addCategoryToUserSubscriptions(category: CategoryModel)

    fun getUserCategorySubscriptions(): Flow<List<CategoryModel>>

    fun removeFromUserCategorySubscriptions()

    fun addSourceToUserSubscriptions(source: SourceModel)

    fun getUserSourceSubscriptions(): Flow<List<SourceModel>>

    fun removeFromUserSourceSubscriptions()

    fun saveArticle(article: ArticleModel)

    fun getUserSavedArticles(): Flow<List<ArticleModel>>

    fun removeFromUserSavedArticles()

}