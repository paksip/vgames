package com.example.vgames.model.dto

import com.example.vgames.model.dto.Game
import com.google.gson.annotations.SerializedName

data class ResponseList(
    @SerializedName("results")
    var results: List<Game>? = null
)