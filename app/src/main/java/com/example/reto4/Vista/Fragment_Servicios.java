package com.example.reto4.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import com.example.reto4.Modelo.Adaptador;
import com.example.reto4.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.reto4.Modelo.Entidad;
import com.example.reto4.R;



public class Fragment_Servicios extends Fragment {

    int [] imagen = {R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4 };

    String TAG = "Fragment_Servicios";

    View v;

    ListView listaServicios;
    Adaptador adaptador;



    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        //-----------------------------------------------------------------------------
        listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(getTablaServicios(), getContext());

        listaServicios.setAdapter(adaptador);

        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaServicios(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();

        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM servicios", null);
        Log.v(TAG, "leyendo base de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "dentro de while");
            //listaProductos.add(new Entidad(R.drawable.s1, cursor.getString(0), cursor.getString(1)));
            listaProductos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));

            Log.v(TAG, "despues del while");
        }

        return listaProductos;
    }

}