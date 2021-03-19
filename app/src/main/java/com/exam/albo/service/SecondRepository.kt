package com.exam.albo.service

import retrofit2.HttpException

class SecondRepository: BaseRepository() {

    suspend fun getBeers() : Resource<ListBeers>{
        return try {
            val beers = serviceBeer.getBeers()
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