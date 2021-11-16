package com.example.pamlab11

import retrofit2.Call
import retrofit2.http.GET




interface ApiInterface {
    @GET("geo")
    fun getIPInfo(): Call<IPInfo?>?
}