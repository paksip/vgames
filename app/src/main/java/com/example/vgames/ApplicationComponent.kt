package com.example.vgames

import com.example.vgames.interactor.InteractorModule
import com.example.vgames.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface ApplicationComponent {
    fun inject(gameListActivity: GameListActivity)
    fun inject(gameDetailActivity: GameDetailActivity)
}