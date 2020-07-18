package com.ajijul.newsnewyorktimes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import fr.dasilvacampos.network.monitoring.ConnectivityStateHolder.registerConnectivityBroadcaster

@HiltAndroidApp
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        registerConnectivityBroadcaster()
    }
}