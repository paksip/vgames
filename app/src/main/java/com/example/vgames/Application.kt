package com.example.vgames

class Application : Application() {
    lateinit var injector: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}