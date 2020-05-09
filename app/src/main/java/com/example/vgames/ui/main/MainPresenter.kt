package com.example.vgames.ui.main

import com.example.vgames.interactor.games.GamesInteractor
import com.example.vgames.interactor.games.event.GetAllGamesEvent
import com.example.vgames.model.dto.Game
import com.example.vgames.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val gamesInteractor: GamesInteractor) : Presenter<MainScreen>() {
    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    override fun detachScreen() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
        super.detachScreen()
    }

    fun load() {
        executor.execute {
            gamesInteractor.getAllGames()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetAllGamesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.games != null) {
                    screen?.showGames(event.games as MutableList<Game>)
                }
            }
        }
    }
}