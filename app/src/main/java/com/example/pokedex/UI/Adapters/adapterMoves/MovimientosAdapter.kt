package com.example.pokedex.UI.Adapters.adapterMoves

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.data.pokemon.model.Movimientos

class MovimientosAdapter : RecyclerView.Adapter<MovimientosViewHolder>() {

    val itemMoves = mutableListOf<Movimientos>()

    fun setListaMoves(lista:List<Movimientos>){
        this.itemMoves.clear()
        this.itemMoves.addAll(lista)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovimientosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovimientosViewHolder(layoutInflater.inflate(R.layout.item_text, parent,false))
    }

    override fun onBindViewHolder(holder: MovimientosViewHolder, position: Int) {
        val item : Movimientos = itemMoves[position]
        holder.bind(item.movimiento)
    }

    override fun getItemCount(): Int = itemMoves.size
}