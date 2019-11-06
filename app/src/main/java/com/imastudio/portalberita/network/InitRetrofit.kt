package com.imastudio.portalberita.network

import com.google.gson.GsonBuilder
import com.imastudio.portalberita.helper.MyConstant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//inisialisasi retrofit
object InitRetrofit {
    val gson = GsonBuilder().setLenient().create()
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    //get instance retrofit
    fun getInstance() : RestApi = retrofit.create(RestApi::class.java)
}