package com.example.controlesseleccion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio2 extends AppCompatActivity {

    ListView listView;
    Web[] arrayWeb = {new Web("1","Google","http://www.google.com","google"),
            new Web("2","Yahoo","http://www.yahoo.com","yahoo"),
            new Web("3","Bing","http://www.bing.com","bing")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        listView = findViewById(R.id.listView);


        AdaptadorWeb adaptadorWeb = new AdaptadorWeb(this,arrayWeb);

        listView.setAdapter(adaptadorWeb);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Web webSeleccionada = (Web)parent.getItemAtPosition(position);

                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(webSeleccionada.getUrl()));
                startActivity(intent);
            }
        });


    }


    class AdaptadorWeb extends ArrayAdapter<Web> {

        public AdaptadorWeb(@NonNull Context context, Web[] resource) {
            super(context, R.layout.list_pais, arrayWeb);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_web, null);

            TextView tvNombre = (TextView)item.findViewById(R.id.tvNombre);
            tvNombre.setText(arrayWeb[position].getNombre());
            TextView tvURL = (TextView)item.findViewById(R.id.tvUrl);
            tvURL.setText(arrayWeb[position].getUrl());
            ImageView imageView = (ImageView) item.findViewById(R.id.imageView);


            Context ctx = getApplicationContext();

            imageView.setImageResource(ctx.getResources().getIdentifier(arrayWeb[position].getImagePath(), "drawable",
                    ctx.getApplicationInfo().packageName));
            return item;
        }
    }
}
