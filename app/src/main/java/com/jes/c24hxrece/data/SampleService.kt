package com.jes.c24hxrece.data

import android.util.Log
import com.jes.c24hxrece.data.model.SampleResponseItem
import javax.inject.Inject

class SampleService @Inject constructor(private val api: SampleApi) {

    suspend fun getAllData(): List<SampleResponseItem> {
        val call = api.getAllData()
        if(call.isSuccessful){
            return call.body() ?: emptyList()
        }
        else{
            Log.d("TAJ", "en el servicio step no sucessfull ${call.code()}")
        }
        return  emptyList()
    }
}
