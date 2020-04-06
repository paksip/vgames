package com.example.vgames

import android.app.Activity

val Activity.injector: ApplicationComponent
    get() {
        return (this.applicationContext as Application).injector
    }