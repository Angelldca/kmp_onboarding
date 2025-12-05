package org.angelldca.helloworld.domain.service

import org.angelldca.helloworld.data.dto.PokemonDto
import org.angelldca.helloworld.data.repository.PokemonRepository
import org.angelldca.helloworld.domain.PokeApiService

class PokemonRepositoryImpl(private val api: PokeApiService) : PokemonRepository {
    override suspend fun getPokemon(name: String): PokemonDto =
        api.getPokemon(name)
}