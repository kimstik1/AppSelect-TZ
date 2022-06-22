package com.kimstik.appselect.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiSchema(
    @SerializedName("results")
    var listResult: List<Results>? = null
)