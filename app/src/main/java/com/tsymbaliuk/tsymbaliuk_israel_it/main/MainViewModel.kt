package com.tsymbaliuk.tsymbaliuk_israel_it.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.AppRepository
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.ArticleModel

class MainViewModel(appRepository: AppRepository) : ViewModel() {

    private val _articleList = appRepository.getNewsByCountry("ua")
    val articleList: LiveData<List<ArticleModel>>
        get() = _articleList

}