package com.example.pokemon;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.pokemon.data.PokemonApi;
import com.example.pokemon.organisation.archi.Pokemon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singleton {
    private static Gson gsonInstance;
    private static PokemonApi pokeApiInstance;
    private static SharedPreferences sharedPreferencesInstance;

    public static Gson getGson(){
        if(gsonInstance == null){
            gsonInstance = new GsonBuilder()
                    .setLenient()
                    .create();
        }
        return gsonInstance;
    }

    public static PokemonApi getPokemonApi(){
        if(pokeApiInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();

            pokeApiInstance = retrofit.create(PokemonApi.class);

        }
        return pokeApiInstance;
    }

    public static SharedPreferences getSharedPreferencesInstance(Context context){
        if(sharedPreferencesInstance == null){
            sharedPreferencesInstance = context.getSharedPreferences("Pokemon", Context.MODE_PRIVATE);
        }
        return sharedPreferencesInstance;
    }
}
