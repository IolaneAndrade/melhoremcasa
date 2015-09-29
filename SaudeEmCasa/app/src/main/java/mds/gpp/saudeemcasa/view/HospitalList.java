package mds.gpp.saudeemcasa.view;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.GPSTracker;

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
        setContentView(R.layout.hospital_list);

        listView = (ListView) findViewById(R.id.listView);
        List<String> lista = new ArrayList<String>();
        lista.add("Hospital Santa Luzia");
        lista.add("Hospital Santa Marta");
        lista.add("Hospital Alvorada");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                lista);
        listView.setAdapter(adapter);



        show = (Button) findViewById(R.id.show_location);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(HospitalList.this);

                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    Toast.makeText(HospitalList.this, "Your location is /nLong" + longitude +
                            "/nLat" + latitude, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
