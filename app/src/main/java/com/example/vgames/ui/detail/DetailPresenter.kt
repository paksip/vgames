package com.example.vgames.ui.detail

import com.example.vgames.interactor.games.GamesInteractor
import com.example.vgames.interactor.games.event.GetGameByIdEvent
import com.example.vgames.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val executor: Executor, private val gamesInteractor: GamesInteractor) : Presenter<DetailScreen>() {
    override fun attachScreen(screen: DetailScreen) {
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

    fun load(gameId: Long) {
        executor.execute {
            gamesInteractor.getGameById(gameId)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetGameByIdEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.game != null) {
                    screen?.showGame(event.game)
                }
            }
        }
    }

}