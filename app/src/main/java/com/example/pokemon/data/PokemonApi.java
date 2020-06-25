package com.example.pokemon.data;

import com.example.pokemon.organisation.archi.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApi {
    @GET("api/v2/pokemon")
    Call<RestPokemonResponse> getPokemonResponse();
}
