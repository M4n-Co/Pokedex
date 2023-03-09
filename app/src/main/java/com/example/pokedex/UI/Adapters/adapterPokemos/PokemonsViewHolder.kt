package com.example.pokedex.UI.Adapters.adapterPokemos

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.pokemons.model.ListPokemons
import com.example.pokedex.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso

class PokemonsViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemPokemonBinding.bind(view)

    fun bind(item:ListPokemons, onClickListener:(ListPokemons)->Unit){
        val nPokemon = item.nombre
        val numero = getNumero(item.url)

        binding.tvNombre.text = nPokemon
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$numero.png")
            .into(binding.ivFoto)

        itemView.setOnClickListener { onClickListener(item)}
    }

    private fun getNumero(url:String): Int {
        val partes = url.split("/")
        val numero = partes[partes.size-2].toInt()
        return numero
    }
}