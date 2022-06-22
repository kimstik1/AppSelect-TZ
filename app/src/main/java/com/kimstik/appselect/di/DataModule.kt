package com.kimstik.appselect.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kimstik.appselect.BuildConfig.API_LINK
import com.kimstik.appselect.data.network.FilmApi
import com.kimstik.appselect.data.network.model.ApiSchema
import com.kimstik.appselect.repository.NetworkRepository
import com.kimstik.appselect.repository.NetworkRepositoryImpl
import com.visoft.data.util.dispatcher.DefaultDispatcherProvider
import com.visoft.data.util.dispatcher.DispatcherProvider
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(API_LINK)
                .client(OkHttpClient())
                .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    fun provideAuthApi(retrofit: Retrofit): FilmApi =
        retrofit.create(FilmApi::class.java)

    @Provides
    fun provideNetworkRepository(filmApi: FilmApi): NetworkRepository =
        NetworkRepositoryImpl(filmApi = filmApi)

    @Provides
    @Singleton
    fun providesDispatcher(): DispatcherProvider = DefaultDispatcherProvider()
}