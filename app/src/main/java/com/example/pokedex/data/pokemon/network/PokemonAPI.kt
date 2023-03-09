package com.example.pokedex.data.pokemon.network

import com.example.pokedex.data.pokemon.model.PokemonModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonAPI {
    @GET
    suspend fun getPokemon(@Url url: String): Response<PokemonModel>
}