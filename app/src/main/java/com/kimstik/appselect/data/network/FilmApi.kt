package com.kimstik.appselect.data.network

import com.kimstik.appselect.BuildConfig
import com.kimstik.appselect.data.network.model.ApiSchema
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApi {
    @GET("svc/movies/v2/reviews/all.json")
    suspend fun getBest(
        @Query("api-key")key: String = BuildConfig.API_KEY,
        @Query("offset")offset: Int
    ): Response<ApiSchema>
}