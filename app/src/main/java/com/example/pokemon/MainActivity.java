package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pokemon.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Rediriger vers la page principal "MainActivity" après 3 secondes.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //Démarrer une page
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
                finish();

            }
        };

        //Handler envoyer avec un délais
        new Handler().postDelayed(runnable, 3000);
    }
}
