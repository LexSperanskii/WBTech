package com.example.ui_v2.di

import com.example.ui_v2.ui.utils.NewUIMockData
import org.koin.dsl.module


val newUIMockDataModule = module {
    single<NewUIMockData> { NewUIMockData() }
}