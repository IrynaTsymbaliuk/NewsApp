package com.tsymbaliuk.tsymbaliuk_israel_it.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.article.usecase.ArticleUseCase

class MainViewModel(private val articleUseCase: ArticleUseCase) : ViewModel() {

    val articleList: LiveData<List<ArticleModel>>
        get() = articleUseCase.getTopUaNews().asLiveData()

}