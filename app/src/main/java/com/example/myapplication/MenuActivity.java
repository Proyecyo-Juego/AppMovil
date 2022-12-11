package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public  void launchPlayGameActivity(View view){
        // jugar al juego
        Intent intent = new Intent(this, ElegirPeleaActivity.class);
        startActivity(intent);
    }

    public void launchPersonajesActivity(View view) {
        Intent intent = new Intent(this, PersonajesActivity.class);
        startActivity(intent);
    }

    public void launchInformacionActivity(View view) {
        Intent intent = new Intent(this, InformacionActivity.class);
        startActivity(intent);
    }

    public void exit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}