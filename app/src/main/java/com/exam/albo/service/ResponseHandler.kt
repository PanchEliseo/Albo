package com.exam.albo.service

import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.HttpException
import java.net.SocketTimeoutException

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

class ResponseHandler {
    fun <T : Any> handleLoading(data: T): Resource<T> {
        return Resource.loading(data)
    }

    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
         when (e) {
            is HttpException -> {
                val errorResponseString = e.response()?.errorBody()?.string()
                 val errorResponse = try {
                     val jsonObject = Gson().fromJson(errorResponseString, JsonObject::class.java)
                     val type = jsonObject.get("type").asString
                     val code = jsonObject.get("code").asString
                     val details = jsonObject.get("details").asString
                     val location = jsonObject.get("location").asString
                     val moreInfo = jsonObject.get("moreInfo").asString
                     val uuid = jsonObject.get("uuid").asString

                     ErrorResponse(
                         code = if(code.isNotEmpty()) code else "${e.code()}",
                         type = type,
                         details = details,
                         location = location,
                         moreInfo = moreInfo,
                         uuid = uuid,
                         timestamp = ""
                     )
                 } catch (ex: Exception){
                     val errorResponseHttp = try {
                         ErrorResponse(
                             code = e.code().toString(),
                             details = e.message()
                         )
                     }catch (ex:Exception){
                        ErrorResponse(code = "0000")
                     }
                     return Resource.error(errorResponseHttp, null)
                 }
               return Resource.error(errorResponse, null)
            }
            is SocketTimeoutException -> {
                val errorResponse = ErrorResponse(code = "${ErrorCodes.SocketTimeOut.code}", details = "${ErrorCodes.SocketTimeOut.code}")
               return Resource.error(errorResponse, null)
            }
            else -> {
                val errorResponse = ErrorResponse(code = "0000")
              return  Resource.error(errorResponse, null)
            }
        }
    }
}
