package com.example.pokedex.data.pokemon

import com.example.pokedex.data.pokemon.model.PokemonModel
import com.example.pokedex.data.pokemon.network.PokemonService
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiService : PokemonService
) {
    suspend fun getPokemonFromRep(nombreP:String):PokemonModel{
        val response = apiService.getPokemonFromServ(nombreP)
        return response
    }
}