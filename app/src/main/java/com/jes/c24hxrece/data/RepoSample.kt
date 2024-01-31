package com.jes.c24hxrece.data

import com.jes.c24hxrece.data.model.SampleResponseItem
import javax.inject.Inject

class RepoSample @Inject constructor(private val service: SampleService) {

    suspend fun getAllData(): List<SampleResponseItem> {
        val call = service.getAllData()
        return call
    }
}

