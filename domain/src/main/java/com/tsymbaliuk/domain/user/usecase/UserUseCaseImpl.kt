package com.tsymbaliuk.domain.user.usecase

import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.category.model.CategoryModel
import com.tsymbaliuk.domain.source.model.SourceModel
import com.tsymbaliuk.domain.user.model.UserModel
import com.tsymbaliuk.domain.user.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserUseCaseImpl(private val repository: UserRepository): UserUseCase {

    override fun signUp(user: UserModel) = repository.signUp(user)

    override fun signIn() = repository.signIn()

    override fun signOut() = repository.signOut()

    override fun addCategoryToUserSubscriptions(category: CategoryModel) = repository.addCategoryToUserSubscriptions(category)

    override fun getUserCategorySubscriptions(): Flow<List<CategoryModel>> = repository.getUserCategorySubscriptions()

    override fun removeFromUserCategorySubscriptions() = repository.removeFromUserCategorySubscriptions()

    override fun addSourceToUserSubscriptions(source: SourceModel) = repository.addSourceToUserSubscriptions(source)

    override fun getUserSourceSubscriptions(): Flow<List<SourceModel>> = repository.getUserSourceSubscriptions()

    override fun removeFromUserSourceSubscriptions() = repository.removeFromUserSourceSubscriptions()

    override fun saveArticle(article: ArticleModel) = repository.saveArticle(article)

    override fun getUserSavedArticles(): Flow<List<ArticleModel>> = repository.getUserSavedArticles()

    override fun removeFromUserSavedArticles() = repository.removeFromUserSavedArticles()

}