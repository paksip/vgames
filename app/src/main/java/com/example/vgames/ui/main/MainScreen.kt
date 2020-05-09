package com.example.vgames.ui.main

import com.example.vgames.model.dto.Game

interface MainScreen {
    fun showGames(games: List<Game>?)
    fun showNetworkError(message: String)
}