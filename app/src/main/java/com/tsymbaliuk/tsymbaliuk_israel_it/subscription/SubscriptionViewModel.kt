package com.tsymbaliuk.tsymbaliuk_israel_it.subscription

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.article.usecase.ArticleUseCase
import com.tsymbaliuk.domain.category.model.CategoryModel
import com.tsymbaliuk.domain.category.usecase.CategoryUseCase
import com.tsymbaliuk.domain.source.model.SourceModel
import com.tsymbaliuk.domain.source.usecase.SourceUseCase

class SubscriptionViewModel(articleUseCase: ArticleUseCase,
sourceUseCase: SourceUseCase, categoryUseCase: CategoryUseCase): ViewModel() {

    val categorySubscriptionList = MutableLiveData<List<CategoryModel>>()

    val sourceSubscriptionList = MutableLiveData<List<SourceModel>>()

    val savedArticleList = MutableLiveData<List<ArticleModel>>()

    /*val categorySubscriptionList: LiveData<List<CategoryModel>>
        get() = repository.getCategorySubscriptions()

    val sourceSubscriptionList: LiveData<List<SourceModel>>
        get() = repository.getSourceSubscriptions()

    val savedArticleList: LiveData<List<ArticleModel>>
        get() = repository.getSavedArticles()*/

}