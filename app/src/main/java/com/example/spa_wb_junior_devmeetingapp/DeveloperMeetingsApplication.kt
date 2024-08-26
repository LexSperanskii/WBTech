package com.example.spa_wb_junior_devmeetingapp

import android.app.Application
import com.example.data.di.dataModule
import com.example.di.ui_v1Module
import com.example.domain.di.domainModule
import com.example.domain.di.mockModule
import com.example.ui_v2.di.ui_v2Module
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DeveloperMeetingsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
//            androidContext(this@App) //контекст если нужен
            modules(listOf(ui_v1Module, ui_v2Module, mockModule, dataModule, domainModule))
        }
    }
}