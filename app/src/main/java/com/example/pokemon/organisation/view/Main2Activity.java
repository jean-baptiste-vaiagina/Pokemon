package com.example.pokemon.organisation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.pokemon.R;

public class Main2Activity extends AppCompatActivity {

    private ImageView image_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.image_bottom = (ImageView) findViewById(R.id.image_bottom);

        image_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ortherActivity = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(ortherActivity);
                finish();
            }
        });
    }
}
