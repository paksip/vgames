package com.example.vgames

import android.app.Activity
import android.support.v4.app.Fragment

val Activity.injector: VGamesApplicationComponent
    get() {
        return (this.applicationContext as VGamesApplication).injector
    }

val Fragment.injector: VGamesApplicationComponent
    get() {
        return (this.context!!.applicationContext as VGamesApplication).injector
    }