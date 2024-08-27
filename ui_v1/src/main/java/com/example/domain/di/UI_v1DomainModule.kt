package com.example.domain.di

import org.koin.dsl.module

internal val uiv1DomainModule = module {

    includes(uiv1UserModule, uiv1EventsModule, uiv1CommunitiesModule)

}