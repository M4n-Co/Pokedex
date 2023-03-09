package com.example.pokedex.data.pokemon.network

import com.example.pokedex.data.pokemon.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonService @Inject constructor(
    private val apiPokemon: PokemonAPI
) {
    suspend fun getPokemonFromServ(nombreP:String):PokemonModel{
        return withContext(Dispatchers.IO){
            val response = apiPokemon.getPokemon("pokemon/$nombreP")
            response.body()!!
        }
    }
}