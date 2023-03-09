package com.example.pokedex.data.pokemons.model

import com.google.gson.annotations.SerializedName

data class ListPokemons(
    @SerializedName("name") val nombre: String,
    @SerializedName("url") val url: String
)