package mds.gpp.saudeemcasa.view;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.google.android.gms.maps.SupportMapFragment;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.GoogleMapController;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by iolane on 15/11/15.
 */
public class MapToHospital extends ActionBarActivity {

    GoogleMapController googleMapController;
    Hospital hospital; //lat and long

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.hospital_map);
    }

    SupportMapFragment fragment = (SupportMapFragment)
            getSupportFragmentManager().findFragmentById(R.id.hospital_map);
    googleMapController = fragment.getMap();
}
