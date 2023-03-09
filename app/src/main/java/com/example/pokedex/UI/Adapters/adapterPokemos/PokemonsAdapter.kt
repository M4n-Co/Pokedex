package com.example.pokedex.UI.Adapters.adapterPokemos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.data.pokemons.model.ListPokemons

class PokemonsAdapter( private var onClickListener: (ListPokemons)-> Unit): RecyclerView.Adapter<PokemonsViewHolder>() {

    var pokemonsList = mutableListOf<ListPokemons>()

    fun setItems(list: List<ListPokemons>){
        this.pokemonsList.clear()
        this.pokemonsList.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return PokemonsViewHolder(layoutInflater.inflate(R.layout.item_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: PokemonsViewHolder, position: Int) {
        val item : ListPokemons = pokemonsList[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int = pokemonsList.size

}