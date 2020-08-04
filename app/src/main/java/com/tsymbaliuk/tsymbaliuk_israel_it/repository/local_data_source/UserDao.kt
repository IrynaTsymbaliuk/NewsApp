package com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source.NewsResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert()
    fun signUp(user: UserEntity)

    @Query("SELECT * FROM UserEntity WHERE email LIKE :email")
    fun findUserWithEmail(email: String): Flow<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE phoneNumber LIKE :phoneNumber")
    fun findUserWithPhoneNumber(phoneNumber: String): Flow<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToCategorySubscriptions(category: CategoryEntity)

    @Query("SELECT * FROM CATEGORYENTITY")
    fun getCategorySubscriptions(): Flow<List<CategoryEntity>>

    @Query("DELETE FROM CATEGORYENTITY WHERE categoryName = :categoryName")
    fun removeFromCategorySubscriptions(categoryName: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToSourceSubscriptions(source: FullSourceEntity)

    @Query("SELECT * FROM FULLSOURCEENTITY")
    fun getSourceSubscriptions(): Flow<List<FullSourceEntity>>

    @Query("DELETE FROM FULLSOURCEENTITY WHERE name = :sourceName")
    fun removeFromSourceSubscriptions(sourceName: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNews(news: ArticleEntity)

    @Query("SELECT * FROM ARTICLEENTITY")
    fun getAllSavedNews(): LiveData<List<ArticleEntity>>

    @Delete
    fun deleteNews(news: ArticleEntity)

}