package com.example.reto4.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reto4.BuildConfig;
import com.example.reto4.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;


public class Fragment_Sucursales extends Fragment {

    View v;


    private MapView myOpenMapView;
    private MapController myMapController;
    GeoPoint Bogota, Usaquen, Suba, Chapinero;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sucursales, container, false);
        //------------------------------------------------------------------------------------------

        myOpenMapView = (MapView) v.findViewById(R.id.openmapview);

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        Bogota = new GeoPoint(4.6351,-74.0703);
        Suba = new GeoPoint(4.7326,-74.0745);
        Chapinero = new GeoPoint(4.6451,-74.0674);
        Usaquen = new GeoPoint(4.7012,-74.0415);

        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Bogota);
        myMapController.setZoom(13);

        myOpenMapView.setMultiTouchControls(true);

        final MyLocationNewOverlay myLocationNewOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()),myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationNewOverlay);
        myLocationNewOverlay.enableMyLocation();

        myLocationNewOverlay.runOnFirstFix(new Runnable(){
            @Override
            public void run() {
                myMapController.animateTo(myLocationNewOverlay.getMyLocation());
            }
        });


        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Sede Chapinero", "CC Plaza 54", Chapinero));
        puntos.add(new OverlayItem("Sede Suba", "Centro Suba", Suba));
        puntos.add(new OverlayItem("Sede Norte", "CC Unicentro", Usaquen));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);


        //------------------------------------------------------------------------------------------
        return v;
    }
}