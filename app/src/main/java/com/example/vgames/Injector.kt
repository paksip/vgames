package com.example.vgames

import android.app.Activity
import androidx.fragment.app.Fragment

val Activity.injector: VGamesApplicationComponent
    get() {
        return (this.applicationContext as VGamesApplication).injector
    }

val Fragment.injector: VGamesApplicationComponent
    get() {
        return (this.context!!.applicationContext as VGamesApplication).injector
    }