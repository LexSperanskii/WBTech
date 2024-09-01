package com.example.generalDI

import com.example.data.di.uiv1DataModule
import com.example.domain.di.uiv1DomainModule
import com.example.domain.di.uiv1MockModule
import com.example.ui_v1.di.uiv1UIModule
import org.koin.dsl.module

val ui_v1Module = module {

    includes(uiv1DomainModule, uiv1MockModule, uiv1DataModule, uiv1UIModule)

}