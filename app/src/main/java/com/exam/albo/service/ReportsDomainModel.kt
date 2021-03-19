package com.exam.albo.service

data class ReportsDomainModel(
        var uuid: Int?,
        var description: String?,
        var creation_date: String?,
        var amount: Float?,
        var category: String?,
        var operation: String?,
        var status: String?
)