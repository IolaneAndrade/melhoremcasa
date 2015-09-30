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
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by gabriel on 29/09/15.
 */
public class HospitalList extends Activity {

    GPSTracker gps;
    Button show;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_list_screen);

        Hospital h1 = new Hospital(0," ", " ", " ", "(61) 3321-8181","Hospital Taxiado", " ", " ", " ",4);
        Hospital h2 = new Hospital(0," ", " ", " ", "(61) 3321-8080","Hospital Uberado", " ", " ", " ",4);
        Hospital h3 = new Hospital(0," ", " ", " ", "(61) 3321-8000","Hospital Motorizado", " ", " ", " ",4);
        Hospital h4 = new Hospital(0," ", " ", " ", "(61) 3321-5151","Hospital Veiculado", " ", " ", " ",4);
        Hospital h5 = new Hospital(0," ", " ", " ", "(61) 3321-0000","Hospital Polemica", " ", " ", " ",4);

        listView = (ListView) findViewById(R.id.listView);
        ArrayList<Hospital> lista = new ArrayList<Hospital>();
        lista.add(h1);
        lista.add(h2);
        lista.add(h3);
        lista.add(h4);
        lista.add(h5);

        HospitalAdapter adapter = new HospitalAdapter(this,lista);

        listView.setAdapter(adapter);



        show = (Button) findViewById(R.id.show_location);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(HospitalList.this);

                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    Toast.makeText(HospitalList.this,"Seu local é \nLONG:"+longitude+"\nLAT:"+latitude,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
