package com.tsymbaliuk.data

import RetrofitFactoryImpl
import com.tsymbaliuk.data.article.ArticleApi
import com.tsymbaliuk.data.article.ArticleRepositoryImpl
import com.tsymbaliuk.data.category.CategoryRepositoryImpl
import com.tsymbaliuk.data.retrofit.RetrofitFactory
import com.tsymbaliuk.data.sharedprefs.SharedPreferencesProviderImpl
import com.tsymbaliuk.data.source.SourceApi
import com.tsymbaliuk.data.source.SourceRepositoryImpl
import com.tsymbaliuk.data.user.UserDatabase
import com.tsymbaliuk.data.user.UserRepositoryImpl
import com.tsymbaliuk.domain.article.repository.ArticleRepository
import com.tsymbaliuk.domain.category.repository.CategoryRepository
import com.tsymbaliuk.domain.source.repository.SourceRepository
import com.tsymbaliuk.domain.user.repository.UserRepository
import kotlinx.coroutines.MainScope
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {

    single<SharedPreferencesProviderImpl> { SharedPreferencesProviderImpl(get()) }

    single<RetrofitFactory> { RetrofitFactoryImpl() }
    single { get<RetrofitFactory>().createRetrofit() }

    single { get<Retrofit>().create(ArticleApi::class.java) }
    single { get<Retrofit>().create(SourceApi::class.java) }

    single<ArticleRepository> { ArticleRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl() }
    single<SourceRepository> { SourceRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }

    single {
        UserDatabase.getDatabase(
            androidApplication(),
            MainScope()).userDao()
    }

}