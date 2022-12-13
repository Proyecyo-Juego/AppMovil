package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.List;

//Adapter, coge listas de jugadores y puntos y los muestra en el ranking
public class RankingAdapter extends ArrayAdapter<Jugador> {
    public RankingAdapter(@NonNull Context context, int resource, @NonNull List<Jugador> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_ranking, parent, false);
        }
        Jugador jugador = getItem(position);
        TextView posicion = view.findViewById(R.id.RankingNumber);
        TextView nombre = view.findViewById(R.id.nombreJugador);
        TextView puntos = view.findViewById(R.id.puntosJugador);
        posicion.setText("Nº " + (position+1));
        nombre.setText(jugador.getNombre());
        puntos.setText(jugador.getPuntosString());
        return view;
    }
}

