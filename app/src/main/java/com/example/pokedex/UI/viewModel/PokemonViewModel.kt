package com.example.pokedex.UI.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.pokemon.model.Movimientos
import com.example.pokedex.data.pokemon.model.PokemonModel
import com.example.pokedex.data.pokemon.model.Tipos
import com.example.pokedex.domain.GetPokemonDetalles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonDetalles: GetPokemonDetalles
):ViewModel(){
    val pokemonVM = MutableLiveData<PokemonModel>()

    fun getDetalles(nombreP:String){
        viewModelScope.launch {
            val pokemonDetalles = getPokemonDetalles(nombreP)
            pokemonVM.postValue(pokemonDetalles)
        }
    }
}