package com.example.spa_wb_junior_devmeetingapp

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.domain.di.mockModule
import com.example.generalDI.ui_v1Module
import com.example.ui_v2.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DeveloperMeetingsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@DeveloperMeetingsApplication)
            modules(
                listOf(
                    uiModule,
                    dataModule,
                    domainModule,
                    mockModule,
                    ui_v1Module
                )
            )
        }
    }
}