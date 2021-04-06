package com.exam.albo.service

import retrofit2.HttpException

class SecondRepository: BaseRepository() {

    suspend fun getBeers(page: Int, perPage: Int) : Resource<ListBeers>{
        return try {
            val urlBeers = "v2/beers?page=$page&per_page=$perPage"
            val beers = serviceBeer.getBeers(url = urlBeers)
            if (beers.isSuccessful) {
                val mapper = beers.body()?.let { SecondMapper().map(it) }
                Resource.success(mapper)
            } else {
                throw HttpException(beers)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            responseHandler.handleException(e)
        }
    }

}