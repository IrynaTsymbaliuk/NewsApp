package com.tsymbaliuk.tsymbaliuk_israel_it

import android.app.Application
import com.tsymbaliuk.tsymbaliuk_israel_it.category.CategoryViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.main.MainViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.press.PressViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.AppRepository
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.local_data_source.UserDatabase
import com.tsymbaliuk.tsymbaliuk_israel_it.repository.remote_data_source.NewsApi
import com.tsymbaliuk.tsymbaliuk_israel_it.subscription.SubscriptionViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.coroutines.coroutineContext
import kotlin.math.sin

val appModule = module {

    viewModel {
        MainViewModel(get())
    }
    viewModel {
        CategoryViewModel(get())
    }
    viewModel {
        PressViewModel(get())
    }
    viewModel {
        SubscriptionViewModel(get())
    }

    single {
        UserDatabase.getDatabase(
            androidApplication(),
            MainScope()
        )
    }

    single {
        AppRepository(get())
    }

}