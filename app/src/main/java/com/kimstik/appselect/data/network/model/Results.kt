package com.kimstik.appselect.data.network.model

import com.google.gson.annotations.SerializedName

data class Results(@SerializedName("display_title")
                   var display_title: String? = null,

                   @SerializedName("summary_short")
                   var summary_short: String? = null,

                   @SerializedName("multimedia")
                   var multimedia: Multimedia? = null) {

    override fun equals(other: Any?): Boolean {
        return false
    }

    override fun hashCode(): Int {
        return Math.random().toInt()
    }
}