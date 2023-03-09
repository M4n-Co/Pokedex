package com.example.pokedex.UI.Adapters.adapterMoves

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.pokemon.model.Movimiento
import com.example.pokedex.databinding.ItemTextBinding

class MovimientosViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemTextBinding.bind(view)

    fun bind(itemMove: Movimiento){
        val moveNombre = itemMove.moveNombre

        binding.tvTexto.text = moveNombre
    }

}