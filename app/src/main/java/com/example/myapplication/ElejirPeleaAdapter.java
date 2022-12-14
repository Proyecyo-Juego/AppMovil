package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.List;

public class ElejirPeleaAdapter extends ArrayAdapter<Pelea> {
    public ElejirPeleaAdapter(@NonNull Context context, int resource, @NonNull List<Pelea> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.opcion_pelea, parent, false);
        }
        Pelea pelea = getItem(position);
        TextView nombre = view.findViewById(R.id.nombrePelea);

        TextView nivel = view.findViewById(R.id.nivelPelea);
        //ImageView imageView = view.findViewById(R.id.imagenPelea);
        nombre.setText(pelea.getNombre());

        nivel.setText(pelea.getNivelString());

        return view;
    }


}
