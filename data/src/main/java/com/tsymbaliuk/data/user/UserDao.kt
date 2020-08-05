package com.tsymbaliuk.data.user

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert()
    fun signUp(user: UserEntity)

    @Query("SELECT * FROM UserEntity WHERE email LIKE :email")
    fun findUserWithEmail(email: String): Flow<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE phoneNumber LIKE :phoneNumber")
    fun findUserWithPhoneNumber(phoneNumber: String): Flow<UserEntity>


    @Transaction
    @Query("SELECT * FROM UserEntity")
    fun getUserWithSubscriptionsAndSaves(): List<UserWithSubscriptionsAndSaves>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToCategorySubscriptions(category: UserCategoryEntity)

    @Query("SELECT * FROM UserCategoryEntity")
    fun getCategorySubscriptions(): Flow<List<UserCategoryEntity>>

    @Query("DELETE FROM UserCategoryEntity WHERE categoryName = :categoryName")
    fun removeFromCategorySubscriptions(categoryName: String)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToSourceSubscriptions(source: UserSourceEntity)

    @Query("SELECT * FROM UserSourceEntity")
    fun getSourceSubscriptions(): Flow<List<UserSourceEntity>>

    @Query("DELETE FROM UserSourceEntity WHERE name = :sourceName")
    fun removeFromSourceSubscriptions(sourceName: String)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNews(news: UserArticleEntity)

    @Query("SELECT * FROM UserArticleEntity")
    fun getAllSavedNews(): LiveData<List<UserArticleEntity>>

    @Delete
    fun deleteNews(news: UserArticleEntity)


}