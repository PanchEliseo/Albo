package com.exam.albo.service

import retrofit2.HttpException
import retrofit2.Response

open class BaseRepository {

    val service = ApiManagerFactory.makeRetrofitService1()
    val serviceBeer = ApiManagerFactory.makeRetrofitService2()
    val responseHandler : ResponseHandler = ResponseHandler()

    protected inline fun <T : Any, R : Any> genericPetitionRest(genericFunction: () -> Response<T>, mapper: (T) -> R):  Resource<R> {
        return try {
            val response = genericFunction()
            if (response.isSuccessful) {
                Resource.success(response.body()?.let { mapper(it) })
            } else {
                throw HttpException(response)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            responseHandler.handleException(e)
        }
    }
}
