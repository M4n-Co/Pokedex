package com.example.pokedex.data.pokemons.model

import com.google.gson.annotations.SerializedName

data class PokemonsModel(
    @SerializedName("results") val pokemons: List<ListPokemons>
)