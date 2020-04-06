package com.example.vgames.interactor

import com.example.vgames.interactor.games.GamesInteractor
import com.example.vgames.network.GamesApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideGamesInteractor(gamesApi: GamesApi) = GamesInteractor(gamesApi)
}