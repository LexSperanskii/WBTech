package com.example.domain.di

import org.koin.dsl.module

val mockModule = module {
    single<MockData> { MockData() }
}