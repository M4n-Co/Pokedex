package com.example.pokedex.UI.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.UI.Adapters.adapterPokemos.PokemonsAdapter
import com.example.pokedex.UI.viewModel.PokedexViewModel
import com.example.pokedex.UI.viewModel.PokemonViewModel
import com.example.pokedex.data.pokemons.model.ListPokemons
import com.example.pokedex.databinding.FragmentFListaPokemonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class fListaPokemon : Fragment() {

    lateinit var _binding : FragmentFListaPokemonBinding
    val binding : FragmentFListaPokemonBinding get() = _binding

    private val pokedexViewModel : PokedexViewModel by viewModels()

    private lateinit var adatador : PokemonsAdapter

    lateinit var comunicador: Comunicador

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentFListaPokemonBinding.inflate(inflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokedexViewModel.mostrarPokemons()

        pokedexViewModel.pokemosVM.observe(viewLifecycleOwner){pokemons->
            initRecycleView(pokemons)
        }
    }

    private fun initRecycleView(lista : List<ListPokemons>) {
        adatador = PokemonsAdapter { onItemSelected(it) }
        adatador.setItems(lista)

        val grid = GridLayoutManager(context,3)
        binding.recyclerView.layoutManager = grid

        binding.recyclerView.adapter = adatador
    }

    private fun onItemSelected(pokemon: ListPokemons) {
        comunicador.showSegundoFrag(pokemon.nombre)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        comunicador = context as Comunicador
    }


}