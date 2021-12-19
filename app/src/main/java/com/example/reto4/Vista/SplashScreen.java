package com.example.reto4.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.reto4.Controlador.MainActivity;
import com.example.reto4.R;

public class SplashScreen extends AppCompatActivity implements Runnable{

    Thread h1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView fondo = (ImageView) findViewById(R.id.fondo);
        fondo.setImageResource(R.drawable.fondo);

        h1 = new Thread(this);
        h1.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}