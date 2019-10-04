package com.example.controlesseleccion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {

    ListView listView;
    Pais[] datos;
    TextView tvDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        listView = findViewById(R.id.listView);
        tvDatos = findViewById(R.id.tvDatos);

        datos = new Pais[] {new Pais("España",5000,100000),
                new Pais("Alemania",2000,700000),
                new Pais("Francia",1000,450000),
                new Pais("Italia",500,60000),
                new Pais("Portugal",200,40000)};

        AdaptadorPais adaptadorPais = new AdaptadorPais(this,datos);

        listView.setAdapter(adaptadorPais);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pais opcionSeleccionada = (Pais)parent.getItemAtPosition(position);

                tvDatos.setText("Superficie: "+opcionSeleccionada.getSuperficie()+". Habitantes: "+opcionSeleccionada.getHabitantes());

            }
        });
    }

    class AdaptadorPais extends ArrayAdapter<Pais>{

        public AdaptadorPais(@NonNull Context context, Pais[] resource) {
            super(context, R.layout.list_pais, datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_pais, null);

            TextView tvNombre = (TextView)item.findViewById(R.id.tvNombre);
            tvNombre.setText(datos[position].getNombre());
            return item;
        }
    }
}
