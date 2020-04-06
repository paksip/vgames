package com.example.vgames.ui

import android.content.Context
import com.example.vgames.interactor.games.GamesInteractor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, gamesInteractor: GamesInteractor) = MainPresenter(executor, gamesInteractor)

    @Provides
    @Singleton
    fun detailPresenter(executor: Executor, gamesInteractor: GamesInteractor) = DetailPresenter(executor, gamesInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)


}