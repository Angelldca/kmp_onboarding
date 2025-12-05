package org.angelldca.helloworld.modules.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(): KoinApplication = startKoin {
    modules(networkModule, dataModule,presentationModule)
}