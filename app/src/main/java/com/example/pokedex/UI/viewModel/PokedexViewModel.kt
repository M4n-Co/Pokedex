package com.example.pokedex.UI.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.pokemon.model.Movimientos
import com.example.pokedex.data.pokemon.model.Tipos
import com.example.pokedex.data.pokemons.model.ListPokemons
import com.example.pokedex.data.pokemons.model.PokemonsModel
import com.example.pokedex.domain.GetPokemonDetalles
import com.example.pokedex.domain.GetPokemonsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokemonsList: GetPokemonsList
):ViewModel(){
    val pokemosVM = MutableLiveData<List<ListPokemons>>()
    val isLoading = MutableLiveData<Boolean>()

    fun mostrarPokemons(){
        viewModelScope.launch {
            isLoading.postValue(true)

            val pokemons = getPokemonsList()
            pokemosVM.postValue(pokemons.pokemons)

            isLoading.postValue(false)
        }
    }

}