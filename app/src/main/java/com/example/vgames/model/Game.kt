package com.example.vgames.model

import java.time.LocalDate
import java.util.*

data class Game(
    var id: String = "",
    var name: String = "",
    var image: Image? = null,
    var deck: String = "",
    var description: String = "",
    var original_release_date: LocalDate,
    var platforms: List<Platform> = Collections.emptyList()

)

data class Image(
    var small_url: String = ""
)

data class Platform(
    var name: String = ""
)