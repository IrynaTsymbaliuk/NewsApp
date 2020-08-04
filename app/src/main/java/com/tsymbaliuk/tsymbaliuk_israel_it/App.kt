package com.tsymbaliuk.tsymbaliuk_israel_it

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()

    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(
                appModule
            )
        }
    }

}