package com.kimstik.appselect.data.network.model

import com.google.gson.annotations.SerializedName

class Multimedia {

    @SerializedName("src")
    var src: String? = null

    @SerializedName("height")
    var height: Int? = null

    @SerializedName("width")
    var width: Int? = null
}