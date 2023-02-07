package com.example.multywork.utils

import android.app.Application
import com.example.multywork.utils.di.AppComponent
import com.example.multywork.utils.di.AppModule
import com.example.multywork.utils.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}