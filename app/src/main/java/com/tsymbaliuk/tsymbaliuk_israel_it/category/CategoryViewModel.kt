package com.tsymbaliuk.tsymbaliuk_israel_it.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.AppRepository
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class CategoryViewModel(appRepository: AppRepository): ViewModel() {

    private val _articleList = appRepository.getNewsByCountry("ua")
    val articleList: LiveData<List<ArticleModel>>
        get() = _articleList

}