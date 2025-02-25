package com.example.farmus_application.model


import com.google.gson.annotations.SerializedName

data class FarmDetail(
    val category: String,
    val description: String,
    val location: String,
    val name: String,
    val owner: String,
    @SerializedName("picture_url")
    val pictureUrl: String,
    val price: Int,
    val squaredMeters: Int,
    val tag: String,
    val term: String
)