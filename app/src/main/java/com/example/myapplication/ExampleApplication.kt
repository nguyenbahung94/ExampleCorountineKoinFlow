package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.mModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ExampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ExampleApplication)
            androidLogger()
            modules(mModules)
        }
    }
}