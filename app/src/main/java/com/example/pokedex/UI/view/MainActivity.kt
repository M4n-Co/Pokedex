package com.example.pokedex.UI.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.replace
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Comunicador {

    companion object{
        val POKEMON = "POKEMON"
    }

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun showSegundoFrag(nombreP:String) {
        val bundle = Bundle()
        bundle.putString(POKEMON,nombreP)
        val transaccion = supportFragmentManager.beginTransaction()
        val fragDetalles = fDetallesPokemon()
        fragDetalles.arguments = bundle
        transaccion.replace(R.id.fragemrntCV, fragDetalles)
        transaccion.addToBackStack(null)
        transaccion.commit()
    }

    override fun showPrimerFrag() {
        val transaccion = supportFragmentManager.beginTransaction()
        val fragLista = fListaPokemon()
        transaccion.replace(R.id.fragemrntCV, fragLista)
        transaccion.addToBackStack(null)
        transaccion.commit()
    }

}

