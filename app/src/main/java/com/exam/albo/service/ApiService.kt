package com.exam.albo.service

import com.exam.albo.service.beers.Beer
import com.exam.albo.service.beers.BeerK
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    //https://gist.githubusercontent.com/astrocumbia/06ec83050ec79170b10a11d1d4924dfe/raw/ad791cddcff6df2ec424bfa3da7cdb86f266c57e/transactions.json
    @GET
    suspend fun getReports(@Url url: String = "astrocumbia/06ec83050ec79170b10a11d1d4924dfe/raw/ad791cddcff6df2ec424bfa3da7cdb86f266c57e/transactions.json"): Response<MutableList<ReportResponse>>

    //https://api.punkapi.com/v2/beers
    @GET
    suspend fun getBeers(@Url url: String = "v2/beers"): Response<MutableList<BeerK>>

}