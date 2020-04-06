package com.example.vgames

import com.example.vgames.interactor.InteractorModule
import com.example.vgames.network.NetworkModule
import com.example.vgames.ui.UIModule
import com.example.vgames.ui.detail.DetailActivity
import com.example.vgames.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface ApplicationComponent {
    fun inject(gameListActivity: MainActivity)
    fun inject(gameDetailActivity: DetailActivity)
}