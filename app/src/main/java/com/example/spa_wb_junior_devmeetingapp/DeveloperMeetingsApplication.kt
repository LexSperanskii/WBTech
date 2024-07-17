package com.example.spa_wb_junior_devmeetingapp

import android.app.Application
import com.example.spa_wb_junior_devmeetingapp.di.appModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DeveloperMeetingsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
//            androidContext(this@App) //контекст если нужен
            modules(appModule) // в listOf() указываем наши модули если много
        }
    }
}