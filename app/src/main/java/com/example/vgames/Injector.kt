package com.example.vgames

import android.app.Activity

val Activity.injector: VGamesApplicationComponent
    get() {
        return (this.applicationContext as VGamesApplication).injector
    }