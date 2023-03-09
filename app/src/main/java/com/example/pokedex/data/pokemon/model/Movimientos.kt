package com.example.pokedex.data.pokemon.model

import com.google.gson.annotations.SerializedName

data class Movimientos(
    @SerializedName("move") val movimiento: Movimiento,
)