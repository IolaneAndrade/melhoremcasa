package mds.gpp.saudeemcasa.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.HospitalController;

public class MapToHospital extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {

        View view = inflater.inflate(R.layout.activity_hospital_maps, null);


    /*public void onResume() {
        super.onResume();

        new Thread() {
            public void run() {
                while (fragmentMap.getMap() == null) ;
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            configMap();
                        }
                    });
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();

    }*/

        //public void configMap() {
        // googleMap = fragmentMap.getMap();
        //googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // controller.updateGoogleMap();
        //}


        return (view);
    }
}

