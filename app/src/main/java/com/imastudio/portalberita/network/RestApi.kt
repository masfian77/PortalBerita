package com.imastudio.portalberita.network

import com.imastudio.portalberita.model.ResponseBerita
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    @GET("top-headlines")
    fun getDataBerita(
        @Query("country") country : String?,
        @Query("apiKey") api : String?
    ) : Call<ResponseBerita>
}