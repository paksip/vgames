package com.example.vgames.model.dto

import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("name")
    var name: String? = null
)