package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class ElegirPeleaActivity extends AppCompatActivity {

    ArrayList<Pelea> peleas = new ArrayList<Pelea>();

    private ListView lvPeleas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pelea);
        lvPeleas = (ListView) findViewById(R.id.peleaListView);
        cargarPeleas();
        ElejirPeleaAdapter adapter = new ElejirPeleaAdapter(this, R.layout.opcion_pelea, peleas);
        lvPeleas.setAdapter(adapter);
    }

    private void cargarPeleas(){
        for (int i = 0; i < 10; i++) {
            peleas.add(new Pelea("Pelea " + i, "Descripcion " + i, i));
        }
    }
    public void Volver(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}
