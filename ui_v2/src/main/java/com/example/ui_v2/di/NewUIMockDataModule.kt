package com.example.ui_v2.di

import com.example.domain.models.MockData
import com.example.ui_v2.ui.utils.NewUIMockData
import org.koin.dsl.module


val newMockDataModule = module {
    single<NewUIMockData> { NewUIMockData() }
}
val mockModule = module {
    single<MockData> { MockData() }
}