package com.example.pokedex.data.pokemons.network

import com.example.pokedex.data.pokemons.model.PokemonsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonsService @Inject constructor(
    private val apiPokemos : PokemonsAPI
) {
    suspend fun getPokemonsFS():PokemonsModel{
        return withContext(Dispatchers.IO){
            val response = apiPokemos.getPokemons("pokemon?limit=151&offset=0")
            response.body()!!
        }
    }
}