package org.angelldca.helloworld.domain

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.angelldca.helloworld.data.dto.PokemonDto

class PokeApiService(private val client: HttpClient) {
     suspend fun getPokemon(name: String): PokemonDto =
        client.get("https://pokeapi.co/api/v2/pokemon/$name").body()
}