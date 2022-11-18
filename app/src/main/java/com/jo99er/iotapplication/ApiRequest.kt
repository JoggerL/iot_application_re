package com.jo99er.iotapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {
    @GET("/api/record/by_ts/{ts}")
//    fun getEcgData():Call<EcgSignal> getEcgData(@Path("ts") Number ts)
    fun getEcgData(@Path("ts") ts: Long?): Call<EcgSignal>
//    fun getUser(@Path("username") username: String?): Call<User?>?
}
