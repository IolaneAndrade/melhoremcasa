package mds.gpp.saudeemcasa.view;

import android.app.ActionBar;
import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import org.json.JSONException;

import java.io.IOException;
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

//    GPSTracker gps;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_list_screen);

        /* Initializing fake hospitals
        Hospital h1 = new Hospital("Hospital Maria Auxiadora de Sao Jose", "(61) 3321-8181");
        Hospital h2 = new Hospital("Hospital Santa Luzia", "(61) 3321-8080");
        Hospital h3 = new Hospital("Hospital do Coracao do Brasil", "(61) 3321-8000");
        Hospital h4 = new Hospital("Hospital Veiculado", "(61) 3321-5151");
        Hospital h5 = new Hospital("Hospital Polemica", "(61) 3321-0000");
        */

        HospitalController hospitalController = HospitalController.getInstance(getApplicationContext());
        try {
            hospitalController.initControllerHospital();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

            // Initializing list view
            listView = (ListView) findViewById(R.id.listView);

            // Initialize and fill list of hospital
        /* ArrayList<Hospital> lista = new ArrayList<Hospital>();
        lista.add(h1);
        lista.add(h2);
        lista.add(h3);
        lista.add(h4);
        lista.add(h5);
            */
            ArrayList<Hospital> lista = (ArrayList)hospitalController.getAllHospitals();

            // Initializing new HospitalAdapter with list of hospitals
            HospitalAdapter adapter = new HospitalAdapter(this, lista);

            // Setting adapter to listView
            listView.setAdapter(adapter);

            // Tirei o botao para nao dar confusao, ele nao sera usado, mas deixe o codigo para usarmos
            // de colinha

//        show = (Button) findViewById(R.id.show_location);
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gps = new GPSTracker(HospitalList.this);
//
//                if(gps.canGetLocation()){
//                    double latitude = gps.getLatitude();
//                    double longitude = gps.getLongitude();
//
//                    Toast.makeText(HospitalList.this,"Seu local é \nLONG:"+longitude+"\nLAT:"+latitude,Toast.LENGTH_LONG).show();
//                }
//            }
//        });
        }
}
