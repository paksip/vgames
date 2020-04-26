package com.example.vgames.interactor.games.event

import com.example.vgames.model.Game

data class GetGameByIdEvent(
    var code: Int = 0,
    var game: Game? = null,
    var throwable: Throwable? = null
)