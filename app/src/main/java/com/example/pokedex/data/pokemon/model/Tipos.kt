package com.example.pokedex.data.pokemon.model

import com.google.gson.annotations.SerializedName

data class Tipos(
    @SerializedName("type") val tipo: Tipo
)