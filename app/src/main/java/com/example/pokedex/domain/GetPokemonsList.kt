package com.example.pokedex.domain

import com.example.pokedex.data.pokemons.PokemosRepository
import com.example.pokedex.data.pokemons.model.PokemonsModel
import javax.inject.Inject

class GetPokemonsList @Inject constructor(
    private val repository: PokemosRepository
){
    suspend operator fun invoke():PokemonsModel{
        val pokemons = repository.getPokemosFR()
        return pokemons
    }
}