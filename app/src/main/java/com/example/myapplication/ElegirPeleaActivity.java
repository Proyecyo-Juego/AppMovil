package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ElegirPeleaActivity extends AppCompatActivity {

    List<Pelea> peleas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pelea);
        cargarPeleas();
        ElejirPeleaAdapter adapter = new ElejirPeleaAdapter(this, R.layout.opcion_pelea, peleas);
    }

    private void cargarPeleas(){
        for (int i = 0; i < 10; i++) {
            peleas.add(new Pelea("Pelea " + i, "Descripcion " + i, i));
        }
    }

}
