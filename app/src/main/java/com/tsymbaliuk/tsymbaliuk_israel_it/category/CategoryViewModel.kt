package com.tsymbaliuk.tsymbaliuk_israel_it.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tsymbaliuk.domain.article.model.ArticleModel
import com.tsymbaliuk.domain.article.usecase.ArticleUseCase
import com.tsymbaliuk.domain.category.usecase.CategoryUseCase

class CategoryViewModel(private val articleUseCase: ArticleUseCase,
                        private val categoryUseCase: CategoryUseCase): ViewModel() {

    val categoryList = categoryUseCase.getAllCategories().asLiveData()

    val articleList: LiveData<List<ArticleModel>>
        get() = articleUseCase.getTopUaNews().asLiveData()

}