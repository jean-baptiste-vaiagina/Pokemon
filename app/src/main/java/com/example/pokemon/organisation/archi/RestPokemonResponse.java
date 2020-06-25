package com.example.pokemon.organisation.archi;

import com.example.pokemon.organisation.archi.Pokemon;

import java.util.List;

public class RestPokemonResponse {
    private Integer count;
    private String next;
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }
}
