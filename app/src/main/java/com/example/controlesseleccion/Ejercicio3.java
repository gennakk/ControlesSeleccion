package com.example.controlesseleccion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.ViewGroup.FOCUS_BLOCK_DESCENDANTS;

public class Ejercicio3 extends AppCompatActivity {

    ListView listView;
    ArrayList<Bitmap> arrayFoto;
    Button btnFoto;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);


        listView = findViewById(R.id.listView);

        arrayFoto = new ArrayList<Bitmap>();


        btnFoto = findViewById(R.id.btnFoto);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

            }
        });

        final AdaptadorFoto adaptadorFoto = new AdaptadorFoto(this,arrayFoto);

        listView.setAdapter(adaptadorFoto);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            arrayFoto.add(imageBitmap);



        }
    }

    class AdaptadorFoto extends ArrayAdapter<Bitmap> {

        public AdaptadorFoto(@NonNull Context context, ArrayList<Bitmap> resource) {
            super(context, R.layout.list_foto, arrayFoto);
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_foto, null);

            ImageView imageView = item.findViewById(R.id.imageView);
            imageView.setImageBitmap(arrayFoto.get(position));

            final RatingBar ratingFoto = item.findViewById(R.id.ratingFoto);


            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    enviarCorreo(v,ratingFoto.getRating(),position);

                }
            });

            return item;
        }


    }

    public void enviarCorreo (View view, double puntuacion,int posicion){
        Intent intent = new Intent (Intent.ACTION_SEND);intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Rating de foto número "+(posicion+1));
                intent.putExtra(Intent.EXTRA_TEXT,"Puntuación = "+puntuacion+"\n Comentarios: ");
                intent.putExtra(Intent.EXTRA_EMAIL,
                    new String[]{"informatika2011@gmail.com"});
        startActivity(intent);}


    /*private static Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        img.recycle();
        return rotatedImg;
    }*/



}
