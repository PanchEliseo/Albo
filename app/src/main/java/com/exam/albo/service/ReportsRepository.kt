package com.exam.albo.service

import retrofit2.HttpException

class ReportsRepository: BaseRepository() {

    suspend fun getReports(): Resource<ListReportResponse>{
        return try {
            val reports = service.getReports("astrocumbia/06ec83050ec79170b10a11d1d4924dfe/raw/ad791cddcff6df2ec424bfa3da7cdb86f266c57e/transactions.json")
            if (reports.isSuccessful) {
                val mapper = reports.body()?.let { ReportsMapper().map(it) }
                Resource.success(mapper)
            } else {
                throw HttpException(reports)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            responseHandler.handleException(e)
        }
    }

}