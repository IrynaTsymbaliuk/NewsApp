package com.tsymbaliuk.data.user

import com.tsymbaliuk.data.conversions.toSourceModel
import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.category.model.CategoryModel
import com.tsymbaliuk.domain.source.model.SourceModel
import com.tsymbaliuk.domain.user.model.UserModel
import com.tsymbaliuk.domain.user.repository.UserRepository
import kotlinx.coroutines.flow.*

class UserRepositoryImpl(private val dao: UserDao) : UserRepository {

    override fun signUp(user: UserModel) {
        TODO("Not yet implemented")
    }

    override fun signIn() {
        TODO("Not yet implemented")
    }

    override fun signOut() {
        TODO("Not yet implemented")
    }

    override fun addCategoryToUserSubscriptions(category: CategoryModel) {
        TODO("Not yet implemented")
    }

    override fun getUserCategorySubscriptions(): Flow<List<CategoryModel>> {
        TODO("Not yet implemented")
    }

    override fun removeFromUserCategorySubscriptions() {
        TODO("Not yet implemented")
    }

    override fun addSourceToUserSubscriptions(source: SourceModel) {
        TODO("Not yet implemented")
    }

    override fun getUserSourceSubscriptions(): Flow<List<SourceModel>> {
        return dao.getSourceSubscriptions().map { list ->
            list.map { it ->
                it.toSourceModel()
            }
        }
    }


    override fun removeFromUserSourceSubscriptions() {
        TODO("Not yet implemented")
    }

    override fun saveArticle(article: ArticleModel) {
        TODO("Not yet implemented")
    }

    override fun getUserSavedArticles(): Flow<List<ArticleModel>> {
        TODO("Not yet implemented")
    }

    override fun removeFromUserSavedArticles() {
        TODO("Not yet implemented")
    }

}