package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

import java.util.*;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.adapter.HospitalAdapter;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by gabriel on 29/09/15.
 */
public class HospitalList extends Activity {

    ListView listView;
    ArrayList<Hospital> list;
    GPSTracker gps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_list_screen);

        // Initializing list view
        listView = (ListView) findViewById(R.id.listView);

        gps = new GPSTracker(this);

        HospitalController hospitalController = HospitalController.getInstance(getApplicationContext());

        // Initialize and fill list of hospital
        list = (ArrayList<Hospital>)hospitalController.getAllHospitals();
        if(gps.canGetLocation()) {

            hospitalController.oganizeListHospitalForDistance(this, list);
            // Initializing new HospitalAdapter with list of hospitals
            HospitalAdapter adapter = new HospitalAdapter(this, list);
            // Setting adapter to listView
            listView.setAdapter(adapter);
        }else {
            Toast.makeText(this, "Voce nao esta conectado ao gps ou a internet!\n Concecte-se para prosseguir.",Toast.LENGTH_LONG);

        }

    }
 }

