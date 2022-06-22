package com.kimstik.appselect.util

import android.app.Application
import com.kimstik.appselect.di.AppComponent
import com.kimstik.appselect.di.AppModule
import com.kimstik.appselect.di.DaggerAppComponent

class AppApplication: Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).build()

    }

    companion object {
        internal lateinit var INSTANCE: AppApplication
            private set
    }
}