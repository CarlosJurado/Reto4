package com.example.reto4.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.example.reto4.Vista.Fragment_Favoritos;
import com.example.reto4.Vista.Fragment_Inicio;
import com.example.reto4.Vista.Fragment_Productos;
import com.example.reto4.Vista.Fragment_Servicios;
import com.example.reto4.Vista.Fragment_Sucursales;
import com.example.reto4.R;

public class MainActivity extends AppCompatActivity {

    Fragment subPantallaInicio, subPantallaProductos, subPantallaServicios, subPantallaSucursales, subPantallaFavoritos;

    FragmentTransaction intercambio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantallaInicio = new Fragment_Inicio();
        subPantallaProductos = new Fragment_Productos();
        subPantallaServicios = new Fragment_Servicios();
        subPantallaSucursales = new Fragment_Sucursales();
        subPantallaFavoritos = new Fragment_Favoritos();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment, subPantallaInicio).commit();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        intercambio = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();
        if (id == R.id.productos) {
            intercambio.replace(R.id.contenedor_fragment,subPantallaProductos).commit();
        }
        if (id == R.id.servicios) {
            intercambio.replace(R.id.contenedor_fragment,subPantallaServicios).commit();
        }
        if (id == R.id.sucursales) {
            intercambio.replace(R.id.contenedor_fragment,subPantallaSucursales).commit();
        }
        if (id == R.id.favoritos) {
            intercambio.replace(R.id.contenedor_fragment,subPantallaFavoritos).commit();
        }
        return super.onOptionsItemSelected(item);
    }

}