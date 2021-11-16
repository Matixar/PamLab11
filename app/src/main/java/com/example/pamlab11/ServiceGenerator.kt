package com.example.pamlab11

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit

import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor

import com.google.gson.GsonBuilder

import com.google.gson.Gson




class ServiceGenerator {
    companion object {
        private val BASE_API_URL = "https://ipinfo.io/"
        private var retrofit: Retrofit? = null
        private val gson = GsonBuilder().create()
        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        private val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        private val okHttpClient: OkHttpClient = okHttpClientBuilder.build()
        @JvmStatic
        fun <T> createService(serviceClass: Class<T>?, ip: String): T {
            retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("$BASE_API_URL$ip/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit?.create(serviceClass)!!
        }
    }
}