package com.example.pokedex.UI.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.UI.Adapters.adapterMoves.MovimientosAdapter
import com.example.pokedex.UI.Adapters.adapterTipos.TiposAdapater
import com.example.pokedex.UI.viewModel.PokemonViewModel
import com.example.pokedex.data.pokemon.model.Movimientos
import com.example.pokedex.data.pokemon.model.Tipos
import com.example.pokedex.databinding.FragmentFDetallesPokemonBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class fDetallesPokemon : Fragment() {

    lateinit var _binding : FragmentFDetallesPokemonBinding
    val binding : FragmentFDetallesPokemonBinding get() = _binding

    private lateinit var adapterTipo : TiposAdapater
    private lateinit var adapterMove : MovimientosAdapter

    private val pokemonViewModel : PokemonViewModel by viewModels()

    lateinit var comunicador: Comunicador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFDetallesPokemonBinding.inflate(inflater)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            val nombreP = requireArguments().getString(MainActivity.POKEMON)

            pokemonViewModel.getDetalles(nombreP!!)

            pokemonViewModel.pokemonVM.observe(viewLifecycleOwner){pokemon ->
                initRecycleTipos(pokemon.types)
                initRecycleMovimientos(pokemon.moviemientos)
                val nombrePokemon = pokemon.nombre

                Picasso.get().load(pokemon.Imagen.front_default).into(binding.ivFoto)
                binding.tvNombre.text = nombrePokemon
            }

            binding.bAtrasFD.setOnClickListener {
                comunicador.showPrimerFrag()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        comunicador = context as Comunicador
    }

    private fun initRecycleMovimientos(movimientos: List<Movimientos>) {
        adapterMove = MovimientosAdapter()
        adapterMove.setListaMoves(movimientos)
        binding.rvMovimientos.layoutManager = LinearLayoutManager(context)
        binding.rvMovimientos.adapter = adapterMove
    }

    private fun initRecycleTipos(tipos: List<Tipos>) {
        adapterTipo = TiposAdapater()
        adapterTipo.setListaTipos(tipos)
        binding.rvTipo.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTipo.adapter = adapterTipo
    }

}