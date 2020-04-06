package com.example.vgames.ui.main

import com.example.vgames.interactor.games.GamesInteractor
import com.example.vgames.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val gamesInteractor: GamesInteractor) : Presenter<MainScreen>() {
    fun showGames() {
        screen?.showGames()
    }
}