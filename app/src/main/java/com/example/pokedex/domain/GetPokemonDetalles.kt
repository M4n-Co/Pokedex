package com.example.pokedex.domain

import com.example.pokedex.data.pokemon.PokemonRepository
import com.example.pokedex.data.pokemon.model.PokemonModel
import javax.inject.Inject

class GetPokemonDetalles @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(nombreP : String):PokemonModel{
        val pokemon = pokemonRepository.getPokemonFromRep(nombreP)
        return pokemon
    }
}