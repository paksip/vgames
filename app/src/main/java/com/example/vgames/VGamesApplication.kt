package com.example.vgames

import android.app.Application
import com.example.vgames.ui.UIModule

class VGamesApplication: Application() {
    lateinit var injector: VGamesApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerVGamesApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}