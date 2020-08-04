package com.tsymbaliuk.tsymbaliuk_israel_it.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.CategoryEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.FullSourceEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.UserDatabase
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.UserEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.CategoryModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.SourceModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source.NewsApi

class AppRepository(private val database: UserDatabase) : NewsRepository,
    UserRepository {

    val NEWSAPI_KEY: String = com.tsymbaliuk.tsymbaliuk_israel_it.BuildConfig.NEWSAPI_KEY

    override fun getNewsWithKeyWord(keyWord: String): LiveData<List<ArticleModel>> {
        return liveData {
            emit(NewsApi.retrofitService.getNewsWithKeyWord(
             "ua", keyWord, NEWSAPI_KEY
            ).toArticleModelList())
        }
    }

    override fun getNewsByCountry(country: String): LiveData<List<ArticleModel>> {
        return liveData {
            emit(NewsApi.retrofitService.getNewsByCountry(
                country, NEWSAPI_KEY
            ).toArticleModelList())
        }
    }

    override fun getNewsByCategory(category: String): LiveData<List<ArticleModel>> {
        return liveData {
            emit(NewsApi.retrofitService.getNewsByCategory(
                "ua", category, NEWSAPI_KEY
            ).toArticleModelList())
        }
    }

    override fun getNewsBySource(sourceName: String): LiveData<List<ArticleModel>> {
        return liveData {
            emit(NewsApi.retrofitService.getNewsBySource(
                sourceName, NEWSAPI_KEY
            ).toArticleModelList())
        }
    }

    override fun getAllSource(): LiveData<List<SourceModel>> {
        return liveData {
            emit(NewsApi.retrofitService.getAllSource(NEWSAPI_KEY).toSourceModelList())
        }
    }

    override fun signUp(email: String, phoneNumber: String, passwordHash: String) {
        database.appDao().signUp(UserEntity(email, phoneNumber, passwordHash))
    }

    override fun logIn() {
        TODO("Not yet implemented")
    }

    override fun logOut() {
        TODO("Not yet implemented")
    }

    override suspend fun addToCategorySubscriptions(categoryName: String) {
        database.appDao().addToCategorySubscriptions(CategoryEntity(categoryName))
    }

    override fun getCategorySubscriptions(): LiveData<List<CategoryModel>> {
        return Transformations.map(
            database.appDao().getCategorySubscriptions().asLiveData()
        ) { list ->
            list.map { it.toCategoryModel() }
        }
    }

    override fun removeFromCategorySubscriptions(categoryName: String) {
        database.appDao().removeFromCategorySubscriptions(categoryName)
    }

    override suspend fun addToSourceSubscriptions(
        name: String, description: String, url: String) {
        database.appDao().addToSourceSubscriptions(
            FullSourceEntity(name, description, url, null, null, null)
        )
    }

    override fun getSourceSubscriptions(): LiveData<List<SourceModel>> {
        val sourceSubscriptionEntityList = database.appDao().getSourceSubscriptions().asLiveData()
        return Transformations.map(sourceSubscriptionEntityList) { list ->
            list.map { it.toSourceModel() }
        }
    }

    override fun removeFromSourceSubscriptions(sourceName: String) {
        database.appDao().removeFromSourceSubscriptions(sourceName)
    }

    override suspend fun saveArticle() {
        TODO("Not yet implemented")
    }

    override fun getSavedArticles(): LiveData<List<ArticleModel>> {
        val savedArticleEntityList = database.appDao().getAllSavedNews()
        return Transformations.map(savedArticleEntityList) { list ->
            list.map { it.toArticleModel() }
        }
    }

    override fun deleteArticle() {
        TODO("Not yet implemented")
    }

}