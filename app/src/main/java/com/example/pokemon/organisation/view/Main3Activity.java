package com.example.pokemon.organisation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.pokemon.Singleton;
import com.example.pokemon.organisation.archi.Pokemon;
import com.example.pokemon.R;
import com.example.pokemon.organisation.control.Control;
import java.util.List;


public class Main3Activity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Control control;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        control = new Control(
                this,
                Singleton.getGson(),
                Singleton.getSharedPreferencesInstance(getApplicationContext())
        );

        control.onStart();

    }



/*
    private List<Pokemon> getDataFromCache() {
        String jsonPokemon = sharedPreferences.getString("jsonPokemonList", null);

        if(jsonPokemon == null){
            return null;
        }else{
            Type listeType = new TypeToken<List<Pokemon>>(){}.getType();
            return gson.fromJson(jsonPokemon, listeType);
        }
    }
*/
    public void showList(List<Pokemon> pokemonList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mAdapter = new ListAdapter(pokemonList, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pokemon item) {
                control.onItemClick(item);
            }
        });

        recyclerView.setAdapter(mAdapter);
    }




    public void showError() {
        Toast.makeText(getApplicationContext(), "Api Error", Toast.LENGTH_SHORT).show();
    }

    public void navigateToDetails(Pokemon pokemon) {

        Intent myIntent = new Intent(Main3Activity.this,Main4Activity.class);
        myIntent.putExtra("pokemonKey", Singleton.getGson().toJson(pokemon));
        Main3Activity.this.startActivity(myIntent);

    }
}
