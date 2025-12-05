package org.angelldca.helloworld.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto (
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int
)