package com.example.pokedex.data.pokemons.network

import com.example.pokedex.data.pokemons.model.PokemonsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonsAPI {
    @GET
    suspend fun getPokemons(@Url url: String):Response<PokemonsModel>
}