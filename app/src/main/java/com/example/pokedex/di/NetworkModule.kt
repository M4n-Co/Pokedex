package com.example.pokedex.di

import com.example.pokedex.data.pokemon.network.PokemonAPI
import com.example.pokedex.data.pokemons.network.PokemonsAPI
import com.example.pokedex.data.pokemons.network.PokemonsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePokemons(retrofit: Retrofit):PokemonsAPI{
        return retrofit.create(PokemonsAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideDetalles(retrofit: Retrofit): PokemonAPI{
        return retrofit.create(PokemonAPI::class.java)
    }

}