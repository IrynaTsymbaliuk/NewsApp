package com.tsymbaliuk.tsymbaliuk_israel_it.subscription

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.AppRepository
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.SourceModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.CategoryModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel

class SubscriptionViewModel(val repository: AppRepository): ViewModel() {

    val categorySubscriptionList: LiveData<List<CategoryModel>>
        get() = repository.getCategorySubscriptions()

    val sourceSubscriptionList: LiveData<List<SourceModel>>
        get() = repository.getSourceSubscriptions()

    val savedArticleList: LiveData<List<ArticleModel>>
        get() = repository.getSavedArticles()

}