package com.example.pokedex.data.pokemon.model

import com.google.gson.annotations.SerializedName

data class Movimiento(
    @SerializedName("name") val moveNombre: String,
)