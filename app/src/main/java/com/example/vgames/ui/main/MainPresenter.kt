package com.example.vgames.ui.main

import com.example.vgames.ui.Presenter

class MainPresenter : Presenter<MainScreen>() {
    fun showGames() {
        screen?.showGames()
    }
}