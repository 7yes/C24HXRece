package com.jes.c24hxrece.domain

import com.jes.c24hxrece.data.RepoSample
import com.jes.c24hxrece.data.model.SampleResponseItem
import javax.inject.Inject

class GetAllUseCase @Inject constructor(private val repoSample: RepoSample) {

    suspend operator fun invoke(): List<SampleResponseItem> {
        return repoSample.getAllData()
    }
}
