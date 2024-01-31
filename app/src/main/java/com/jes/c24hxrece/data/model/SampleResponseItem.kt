package com.jes.c24hxrece.data.model

import com.google.gson.annotations.SerializedName

data class SampleResponseItem(
    @SerializedName("description") val description: String,
    @SerializedName("ingredients") val ingredients: List<String>,
    @SerializedName("location") val location: Location,
    @SerializedName("name") val name: String,
    @SerializedName("photo") val photo: String
)
