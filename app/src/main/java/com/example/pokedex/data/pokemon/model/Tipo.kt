package com.example.pokedex.data.pokemon.model

import com.google.gson.annotations.SerializedName

data class Tipo(
    @SerializedName("name") val typeNombre: String
)