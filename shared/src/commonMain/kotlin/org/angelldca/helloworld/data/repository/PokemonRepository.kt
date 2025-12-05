package org.angelldca.helloworld.data.repository

import org.angelldca.helloworld.data.dto.PokemonDto

interface PokemonRepository {
    suspend fun getPokemon(name: String): PokemonDto
}