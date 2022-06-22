package com.kimstik.appselect.di

import com.kimstik.appselect.presentation.MainActivity
import com.kimstik.appselect.presentation.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {
    fun injectMainViewModel(mainActivity: MainActivity)
    fun injectSplashViewModel(splashActivity: SplashActivity)
}