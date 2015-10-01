package mds.gpp.saudeemcasa.view;

import android.app.ActionBar;
import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.adapter.HospitalAdapter;
import mds.gpp.saudeemcasa.adapter.HospitalAdapterWithoutGPS;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by gabriel on 29/09/15.
 */
public class HospitalList extends Activity {

    ListView listView;
    List<Hospital> listAdapter;
    ArrayList<Hospital> list;
    float[] distances;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_list_screen);

        // Initialize and fill list of hospital
        listAdapter = HospitalController.getAllHospitals();
        list = (ArrayList<Hospital>)listAdapter;
        distances = HospitalController.getDistance(this,list);

        // Initializing list view
        listView = (ListView) findViewById(R.id.listView);


        // Initializing new HospitalAdapter with list of hospitals
        if(distances != null) {
            HospitalAdapter adapter = new HospitalAdapter(this, list, distances);
            // Setting adapter to listView
            listView.setAdapter(adapter);
        }else {
            HospitalAdapterWithoutGPS adapter = new HospitalAdapterWithoutGPS(this,list);
            listView.setAdapter(adapter);
        }



    }
}
