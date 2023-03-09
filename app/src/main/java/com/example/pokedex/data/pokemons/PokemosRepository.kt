package com.example.pokedex.data.pokemons

import com.example.pokedex.data.pokemons.model.PokemonsModel
import com.example.pokedex.data.pokemons.network.PokemonsService
import javax.inject.Inject

class PokemosRepository @Inject constructor(
    private val api : PokemonsService
) {
    suspend fun getPokemosFR():PokemonsModel{
        val response = api.getPokemonsFS()
        return response
    }
}