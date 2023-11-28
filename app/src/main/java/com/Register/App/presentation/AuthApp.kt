package com.Register.App.presentation

import android.app.Application
import com.Register.App.di.DaggerApplicationComponent

class AuthApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

}