package com.tsymbaliuk.tsymbaliuk_israel_it

import com.tsymbaliuk.tsymbaliuk_israel_it.category.CategoryViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.login.SignViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.main.MainViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.press.PressViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.source.SourceViewModel
import com.tsymbaliuk.tsymbaliuk_israel_it.subscription.SubscriptionViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        CategoryViewModel(get(), get())
    }

    viewModel {
        SignViewModel(get())
    }

    viewModel {
        MainViewModel(get())
    }

    viewModel {
        PressViewModel(get(), get())
    }

    viewModel {
        SourceViewModel(get())
    }

    viewModel {
        SubscriptionViewModel(get(), get(), get())
    }

    /*single {
        UserDatabase.getDatabase(
            androidApplication(),
            MainScope()
        )
    }*/

    /*single {
        AppRepository(get(), get())
    }*/

}