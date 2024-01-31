package com.jes.c24hxrece.data

import com.jes.c24hxrece.data.model.SampleResponseItem
import javax.inject.Inject

class SampleService @Inject constructor(private val api: SampleApi) {

    suspend fun getAllData(): List<SampleResponseItem> {
        val call = api.getAllData()
        val body = call.body()

        return body ?: emptyList()
    }
}
