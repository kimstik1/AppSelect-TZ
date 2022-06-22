package com.kimstik.appselect.repository

import com.kimstik.appselect.data.network.model.ApiSchema

interface NetworkRepository {

    suspend fun getData(offset: Int): ApiSchema?
}