package com.tsymbaliuk.tsymbaliuk_israel_it.press

import androidx.lifecycle.*
import com.tsymbaliuk.domain.source.model.SourceModel
import com.tsymbaliuk.domain.source.usecase.SourceUseCase
import com.tsymbaliuk.domain.user.usecase.UserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PressViewModel(
    private val userUseCase: UserUseCase,
    private val sourceUseCase: SourceUseCase
) : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private  var subscriptionSourceList  = userUseCase.getUserSourceSubscriptions().asLiveData()
    private var topSourceList =  sourceUseCase.getAllSources().asLiveData()

    val mergedSourceList = MediatorLiveData<ArrayList<SourceModel>>().apply { value = ArrayList<SourceModel>() }

    init {
        mergedSourceList.addSource(subscriptionSourceList, Observer {
            combineSourceLists()
        })
        mergedSourceList.addSource(topSourceList, Observer {
            combineSourceLists()
        })
    }

    private fun getSubscriptionSourceList() { coroutineScope.launch {} }

    fun addToSubscriptions(position: Int) {

        /*coroutineScope.launch {
            try {
                Log.v("Error", "try to save source subscription")
                repository.addToSourceSubscriptions(
                    sourceList.value!![position].name ?: "",
                    sourceList.value!![position].description ?: "",
                    sourceList.value!![position].url ?: ""
                )
            } catch (e: Exception) {
                Log.v("Error", "error with saving source subscription")
            }
        }*/

    }

    private fun combineSourceLists() {

        val subscriptionList = subscriptionSourceList.value
        val topList = topSourceList.value

        mergedSourceList.value?.clear()

        if (!subscriptionList.isNullOrEmpty()) {
            mergedSourceList.value?.addAll(subscriptionList)
            mergedSourceList.value = mergedSourceList.value
        } else if (!topList.isNullOrEmpty()) {
            mergedSourceList.value?.addAll(topList)
            mergedSourceList.value = mergedSourceList.value
        }

    }


}