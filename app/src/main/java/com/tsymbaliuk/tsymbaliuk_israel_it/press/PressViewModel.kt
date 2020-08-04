package com.tsymbaliuk.tsymbaliuk_israel_it.press

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.AppRepository
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.FullSourceEntity
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.UserDatabase
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.model.SourceModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source.NewsApi
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source.SourceResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PressViewModel(val repository: AppRepository) : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val sourceList: LiveData<List<SourceModel>>
        get() = repository.getAllSource()

    private val sourceSubscriptionList: LiveData<List<SourceModel>>
        get() = repository.getSourceSubscriptions()

    fun addToSubscriptions(position: Int) {

        coroutineScope.launch {
            try {
                repository.addToSourceSubscriptions(
                    sourceList.value!![position].name ?: "",
                    sourceList.value!![position].description ?: "",
                    sourceList.value!![position].url ?: ""
                )
            } catch (e: Exception) {
                Log.v("Error", e.message.toString())
            }
        }

    }

}