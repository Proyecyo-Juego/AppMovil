package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    private ListView lvRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        lvRanking = (ListView) findViewById(R.id.Ranking_listView);
        cargarJugadores();
        RankingAdapter adapter = new RankingAdapter(this, R.layout.item_ranking, jugadores);
        lvRanking.setAdapter(adapter);
    }

    private void cargarJugadores(){
        for (int i = 0; i < 10; i++) {
            jugadores.add(new Jugador("Jugador " + i, i));
            jugadores.get(i).setPuntos(10-i);
        }
    }

    public void Volver(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}

