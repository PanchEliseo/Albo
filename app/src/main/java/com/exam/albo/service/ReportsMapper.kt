package com.exam.albo.service

class ReportsMapper: Mapper<MutableList<ReportResponse>, ListReportResponse> {

    override suspend fun map(input: MutableList<ReportResponse>): ListReportResponse {
        return ListReportResponse(
                input.map {
                    ReportResponse(
                            uuid = it.uuid,
                            description = it.description,
                            creation_date = it.creation_date,
                            amount = it.amount,
                            category = it.category,
                            operation = it.operation,
                            status = it.status
                    )
                }.toMutableList()
        )
    }

}