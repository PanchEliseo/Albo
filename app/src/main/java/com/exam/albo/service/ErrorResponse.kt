package com.exam.albo.service

import com.google.gson.annotations.SerializedName

data class ErrorResponse (
    @SerializedName("type")
    val type: String = "",
    @SerializedName("code")
    val code: String = "",
    @SerializedName("details")
    val details: String? = "",
    @SerializedName("location")
    val location: String? = "",
    @SerializedName("moreInfo")
    val moreInfo: String? = "",
    @SerializedName("uuid")
    val uuid: String? = "",
    @SerializedName("timestamp")
    val timestamp: String? = ""
)