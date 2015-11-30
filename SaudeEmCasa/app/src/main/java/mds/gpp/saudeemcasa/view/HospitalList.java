package mds.gpp.saudeemcasa.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;

import java.util.*;

import api.Exception.ConnectionErrorException;
import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.adapter.HospitalAdapter;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by gabriel on 29/09/15.
 */
public class HospitalList extends AppCompatActivity {

    ListView listView;
    View menu;
    ArrayList<Hospital> list;
    GPSTracker gps;
    int hospital = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.list_screen_hospital);

        // Initializing list view
        listView = (ListView) findViewById(R.id.listView);
        menu = findViewById(R.id.topbar_back);

        gps = new GPSTracker(this);

        // Instancing controller
        final HospitalController hospitalController = HospitalController.getInstance(getApplicationContext());
        // Initialize and fill list of hospital
        list = (ArrayList<Hospital>) HospitalController.getAllHospitals();

        if(gps.canGetLocation()) {

            hospitalController.setDistance(getApplicationContext(), list);
            // Initializing new HospitalAdapter with list of hospitals
            HospitalAdapter adapter = new HospitalAdapter(getApplicationContext(), list);
            // Setting adapter to listView
            listView.setAdapter(adapter);
        }else {
            Toast.makeText(getApplicationContext(), "Voce nao esta conectado ao gps ou a internet!\n Conecte-se para prosseguir.",Toast.LENGTH_LONG).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position,
                                    long id) {
                hospitalController.setHospital(list.get(position));
                Intent intent = new Intent(getBaseContext(), GoogleMapHospital.class);
                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HospitalList.this, ChooseScreen.class); // essa é activity Inicial do app
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // adiciona a flag para a intent
                startActivity(intent);
            }
        });


    }
 }

