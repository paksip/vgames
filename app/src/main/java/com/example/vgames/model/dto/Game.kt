package com.example.vgames.model.dto

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Game(
    @SerializedName("id")
    var id: Long? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("image")
    var image: Image? = null,
    @SerializedName("deck")
    var deck: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("original_release_date")
    var originalReleaseDate: String? = null,
    @SerializedName("platforms")
    var platforms: List<Platform>? = null
)
