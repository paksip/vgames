package com.example.vgames.ui.detail

import com.example.vgames.model.dto.Game

interface DetailScreen {
    fun showGame(game: Game?)
    fun showNetworkError(message: String)
}