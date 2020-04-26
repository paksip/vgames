package com.example.vgames.interactor.games.event

import com.example.vgames.model.Game

data class GetAllGamesEvent(
    var code: Int = 0,
    var games: List<Game>? = null,
    var throwable: Throwable? = null
)