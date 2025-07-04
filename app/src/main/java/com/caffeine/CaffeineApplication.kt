package com.caffeine

import android.app.Application
import com.caffeine.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CaffeineApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CaffeineApplication)
            modules(viewModelModule)
        }
    }
}