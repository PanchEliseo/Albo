package com.exam.albo.service

import com.google.gson.annotations.SerializedName

data class ReportResponse(@SerializedName("uuid")
                     val uuid: Int?,
                     @SerializedName("description")
                     val description: String?,
                     @SerializedName("creation_date")
                     val creation_date: String?,
                     @SerializedName("amount")
                     val amount: Float?,
                     @SerializedName("category")
                     val category: String?,
                     @SerializedName("operation")
                     val operation: String?,
                     @SerializedName("status")
                     val status: String?
) {
}