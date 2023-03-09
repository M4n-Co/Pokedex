package com.example.pokedex.data.pokemon.model

import com.google.gson.annotations.SerializedName


data class PokemonModel(
    @SerializedName("moves") val moviemientos: List<Movimientos>,
    @SerializedName("name") val nombre: String,
    @SerializedName("sprites") val Imagen: Imagenes,
    @SerializedName("types") val types: List<Tipos>,
)