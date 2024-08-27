package com.example.domain.di

import com.example.domain.models.Uiv1MockData
import org.koin.dsl.module

internal val uiv1MockModule = module {
    single<Uiv1MockData> { Uiv1MockData() }
}