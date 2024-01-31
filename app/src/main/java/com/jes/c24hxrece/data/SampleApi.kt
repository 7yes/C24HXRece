package com.jes.c24hxrece.data

import com.jes.c24hxrece.data.model.SampleResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {

    @GET("recetas")
    suspend fun getAllData(): Response<List<SampleResponseItem>>

}
