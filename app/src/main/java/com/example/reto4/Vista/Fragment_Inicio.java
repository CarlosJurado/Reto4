package com.example.reto4.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.reto4.R;


public class Fragment_Inicio extends Fragment {


    Drawable drawableFondo;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__inicio, container, false);

        //------------------------------------------------------------------------------------------

        Resources res1 = getResources();
        drawableFondo = res1.getDrawable(R.drawable.fondo,v.getContext().getTheme());






        //------------------------------------------------------------------------------------------
        return v;
    }
}