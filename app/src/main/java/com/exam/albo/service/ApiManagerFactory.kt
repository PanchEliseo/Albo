package com.exam.albo.service

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedInputStream
import java.io.InputStream
import java.lang.reflect.Type
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

object ApiManagerFactory {

    fun makeRetrofitService1(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    fun makeRetrofitService2(): ApiService {
        return Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
    }

}