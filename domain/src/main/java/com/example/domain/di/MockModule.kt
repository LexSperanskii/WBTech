package com.example.domain.di

import com.example.domain.models.mock.MockData
import org.koin.dsl.module

val mockModule = module {
    single<MockData> { MockData() }
}
