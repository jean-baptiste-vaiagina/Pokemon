package com.example.pokemon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApi {
    @GET("api/v2/pokemon/")
    Call<RestPokemonResponse> getPokemonResponse();
}
