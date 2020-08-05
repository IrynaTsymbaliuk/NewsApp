package com.tsymbaliuk.domain

import com.tsymbaliuk.domain.article.usecase.ArticleUseCase
import com.tsymbaliuk.domain.article.usecase.ArticleUseCaseImpl
import com.tsymbaliuk.domain.category.usecase.CategoryUseCase
import com.tsymbaliuk.domain.category.usecase.CategoryUseCaseImpl
import com.tsymbaliuk.domain.source.usecase.SourceUseCase
import com.tsymbaliuk.domain.source.usecase.SourceUseCaseImpl
import com.tsymbaliuk.domain.user.usecase.UserUseCase
import com.tsymbaliuk.domain.user.usecase.UserUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<ArticleUseCase> { ArticleUseCaseImpl(get()) }
    factory<CategoryUseCase> { CategoryUseCaseImpl(get()) }
    factory<SourceUseCase> { SourceUseCaseImpl(get()) }
    factory<UserUseCase> { UserUseCaseImpl(get()) }
}