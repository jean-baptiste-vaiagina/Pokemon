package com.example.pokemon;

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
