package com.kimstik.appselect.repository

import com.kimstik.appselect.data.network.FilmApi
import com.kimstik.appselect.data.network.model.ApiSchema

class NetworkRepositoryImpl(private val filmApi: FilmApi): NetworkRepository {

    override suspend fun getData(offset: Int): ApiSchema? = filmApi.getBest(offset = offset).body()
}