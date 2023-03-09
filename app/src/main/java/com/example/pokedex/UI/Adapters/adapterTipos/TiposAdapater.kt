package com.example.pokedex.UI.Adapters.adapterTipos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.data.pokemon.model.Tipos

class TiposAdapater ():RecyclerView.Adapter<TiposViewHolder>(){

    val itemTipo = mutableListOf<Tipos>()

    fun setListaTipos(lista : List<Tipos>){
        this.itemTipo.clear()
        this.itemTipo.addAll(lista)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiposViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TiposViewHolder(layoutInflater.inflate(R.layout.item_text, parent, false))
    }

    override fun onBindViewHolder(holder: TiposViewHolder, position: Int) {
        val item : Tipos = itemTipo[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemTipo.size
}