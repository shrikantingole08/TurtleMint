package com.test.turtlemint.app

import com.test.turtlemint.base.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    companion object {
        lateinit var instance: App
    }
}