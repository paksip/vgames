package com.example.vgames

import com.example.vgames.interactor.InteractorModule
import com.example.vgames.mock.network.MockNetworkModule
import com.example.vgames.model.db.RoomModule
import com.example.vgames.test.GamesTest
import com.example.vgames.test.MainTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class, RoomModule::class])
interface TestComponent : VGamesApplicationComponent {
    fun inject(detailsTest: GamesTest)
    fun inject(mainTest: MainTest)
}