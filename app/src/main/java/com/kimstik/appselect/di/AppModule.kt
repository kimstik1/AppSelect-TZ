package com.kimstik.appselect.di

import android.content.Context
import com.kimstik.appselect.data.network.FilmApi
import com.kimstik.appselect.presentation.viewmodel.factory.MainViewModelFactory
import com.kimstik.appselect.presentation.viewmodel.factory.SplashViewModelFactory
import com.kimstik.appselect.repository.NetworkRepository
import com.visoft.data.util.dispatcher.DispatcherProvider
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context.applicationContext

    @Provides
    fun provideMainViewModelFactory(repos: NetworkRepository, dispatchers: DispatcherProvider): MainViewModelFactory =
        MainViewModelFactory(repos = repos, dispatchers = dispatchers)

    @Provides
    fun provideSplashViewModelFactory(repos: NetworkRepository, dispatchers: DispatcherProvider): SplashViewModelFactory =
        SplashViewModelFactory(repos = repos, dispatchers = dispatchers)
}