package com.example.di

import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.domain.di.mockModule
import com.example.ui_v1.di.uiModule
import org.koin.dsl.module

val ui_v1Module = module {

    includes(domainModule, mockModule, dataModule, uiModule)

}