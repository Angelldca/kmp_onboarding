package org.angelldca.helloworld.modules.di

import org.angelldca.helloworld.data.repository.PokemonRepository
import org.angelldca.helloworld.domain.PokeApiService
import org.angelldca.helloworld.domain.service.PokemonRepositoryImpl
import org.angelldca.helloworld.infrastructure.platformHttpClient
import org.angelldca.helloworld.presentation.PokemonSearchViewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val networkModule: Module = module {
    single { platformHttpClient() }   // HttpClient singleton
    single { PokeApiService(get()) } //poke api deberia ser el servicio?
}

val dataModule: Module = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get()) }
}
val presentationModule = module {
    factory { PokemonSearchViewModel(get()) }
}