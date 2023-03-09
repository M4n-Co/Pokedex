package com.example.pokedex.UI.Adapters.adapterTipos

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.pokemon.model.Tipo
import com.example.pokedex.data.pokemon.model.Tipos
import com.example.pokedex.databinding.ItemTextBinding

class TiposViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemTextBinding.bind(view)

    fun bind(itemTipo: Tipos){
        val tipoNombre = itemTipo.tipo.typeNombre

        binding.tvTexto.text = tipoNombre
    }
}