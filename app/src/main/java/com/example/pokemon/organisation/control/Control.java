package com.example.pokemon.organisation.control;

import android.content.SharedPreferences;

import com.example.pokemon.Constants;
import com.example.pokemon.Singleton;
import com.example.pokemon.organisation.archi.Pokemon;
import com.example.pokemon.organisation.archi.RestPokemonResponse;
import com.example.pokemon.organisation.view.Main3Activity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Control {
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private Main3Activity view;

    public Control(Main3Activity mainActivity, Gson gson, SharedPreferences sharedPreferences){
        this.view = mainActivity;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
    }

    public void onStart() {


        List<Pokemon> pokemonList = getDataFromCache();

        if (pokemonList != null) {
            view.showList(pokemonList);
        } else {
            makeApiCall();
        }
    }
    private void makeApiCall(){

        Call<RestPokemonResponse> call = Singleton.getPokemonApi().getPokemonResponse();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    List<Pokemon> pokemonList = response.body().getResults();
                    saveList(pokemonList);
                    view.showList(pokemonList);
                }else{
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                view.showError();
            }
        });
    }

    private void saveList(List<Pokemon> pokemonList) {

        String jsonString = gson.toJson(pokemonList);

        sharedPreferences
                .edit()
                .putString(Constants.KEY_POKEMON_LIST, jsonString)
                .apply();
    }

    private List<Pokemon> getDataFromCache() {
        String jsonPokemon = sharedPreferences.getString(Constants.KEY_POKEMON_LIST, null);

        if(jsonPokemon == null){
            return null;
        }else{
            Type listType = new TypeToken<List<Pokemon>>(){}.getType();
            return  gson.fromJson(jsonPokemon, listType);
        }



    }

    public void onItemClick(Pokemon pokemon){
        view.navigateToDetails(pokemon);

    }

}
