package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView imagen;
    int posicion = 0, repeat = 2;

    MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = findViewById(R.id.btnplay);
        btn_repetir = findViewById(R.id.btnrepeat);
        imagen = findViewById(R.id.imageView);

        vectormp [0] = MediaPlayer.create(this,R.raw.lollypop);
        vectormp [1] = MediaPlayer.create(this,R.raw.mapofavo);
        vectormp [2] = MediaPlayer.create(this,R.raw.rock);
    }

    //Metodo para el botón PlayPause
    public void PlayPause (View view){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"Pausa",Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el boton Stop
    public void Stop (View view){
        if (vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp [0] = MediaPlayer.create(this,R.raw.lollypop);
            vectormp [1] = MediaPlayer.create(this,R.raw.mapofavo);
            vectormp [2] = MediaPlayer.create(this,R.raw.rock);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            imagen.setImageResource(R.drawable.lollypop1);
            Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo repetir una pista
    public void Repetir (View view) {
        if (repeat == 1) {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "NO Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repeat = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Si Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repeat = 1;
        }
    }

            //Metodo para saltar a la siguiente cancion
            public void Siguiente (View view){
                if (posicion < vectormp.length - 1) {

                    if (vectormp[posicion].isPlaying()) {
                        vectormp[posicion].stop();
                        posicion++;
                        vectormp[posicion].start();

                        if (posicion == 0) {
                            imagen.setImageResource(R.drawable.lollypop1);
                            Toast.makeText(this, "Cancion 1", Toast.LENGTH_SHORT).show();
                        } else if (posicion == 1) {
                            imagen.setImageResource(R.drawable.mapofavo2);
                            Toast.makeText(this, "Cancion 2", Toast.LENGTH_SHORT).show();
                        } else if (posicion == 2) {
                            imagen.setImageResource(R.drawable.rock3);
                            Toast.makeText(this, "Cancion 3", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        posicion++;

                        if (posicion == 0) {
                            imagen.setImageResource(R.drawable.lollypop1);
                            Toast.makeText(this, "Cancion 1", Toast.LENGTH_SHORT).show();
                        } else if (posicion == 1) {
                            imagen.setImageResource(R.drawable.mapofavo2);
                            Toast.makeText(this, "Cancion 2", Toast.LENGTH_SHORT).show();
                        } else if (posicion == 2) {
                            imagen.setImageResource(R.drawable.rock3);
                            Toast.makeText(this, "Cancion 3", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
                }
            }

            //Metodo para regresar a la cancion anterior
            public void Anterior (View view){
                if (posicion >= 1) {

                    if (vectormp[posicion].isPlaying()) {
                        vectormp[posicion].stop();
                        vectormp[0] = MediaPlayer.create(this, R.raw.lollypop);
                        vectormp[1] = MediaPlayer.create(this, R.raw.mapofavo);
                        vectormp[2] = MediaPlayer.create(this, R.raw.rock);
                        posicion--;

                        if (posicion == 0) {
                            imagen.setImageResource(R.drawable.lollypop1);
                            Toast.makeText(this, "Cancion 1", Toast.LENGTH_SHORT).show();
                        } else if (posicion == 1) {
                            imagen.setImageResource(R.drawable.mapofavo2);
                            Toast.makeText(this, "Cancion 2", Toast.LENGTH_SHORT).show();
                        } else if (posicion == 2) {
                            imagen.setImageResource(R.drawable.rock3);
                            Toast.makeText(this, "Cancion 3", Toast.LENGTH_SHORT).show();
                        }

                        vectormp[posicion].start();

                    } else {
                        posicion--;

                        if (posicion == 0) {
                            imagen.setImageResource(R.drawable.lollypop1);
                            Toast.makeText(this, "Cancion 1", Toast.LENGTH_SHORT).show();
                        } else if (posicion == 1) {
                            imagen.setImageResource(R.drawable.mapofavo2);
                            Toast.makeText(this, "Cancion 2", Toast.LENGTH_SHORT).show();
                        } else if (posicion == 2) {
                            imagen.setImageResource(R.drawable.rock3);
                            Toast.makeText(this, "Cancion 3", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
                }
            }
        }
