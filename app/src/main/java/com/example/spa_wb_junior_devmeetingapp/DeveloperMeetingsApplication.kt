package com.example.spa_wb_junior_devmeetingapp

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.domain.di.mockModule
import com.example.spa_wb_junior_devmeetingapp.di.appModule
import com.example.spa_wb_junior_devmeetingapp.di.newAppModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DeveloperMeetingsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
//            androidContext(this@App) //контекст если нужен
            modules(listOf(newAppModule, appModule, mockModule, dataModule, domainModule))
        }
    }
}