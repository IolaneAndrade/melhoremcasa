package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.adapter.DrugStoreAdapter;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.controller.DrugStoreController;

public class DrugStoreList extends Activity {

    ListView listView;
    View menu;
    ArrayList<DrugStore> list;
    GPSTracker gps;
    int drugstore = -1;

    static final String STATE_SCORE = "playerScore";
    static final String STATE_LEVEL = "playerLevel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_screen_activity);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
           // Restore value of members from saved state
           mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
           mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
        } else {
                // Probably initialize members with default values for a new instance
            }



        // Initializing list view
        listView = (ListView) findViewById(R.id.listView);

        menu = findViewById(R.id.topbar_description);

        gps = new GPSTracker(this);

        // Instancing controller
        final DrugStoreController drugStoreController = DrugStoreController.getInstance(this);

        // Initialize and fill list of drugstore
        list = (ArrayList<DrugStore>) drugStoreController.getAllDrugstores();

        if (gps.canGetLocation()) {
            drugStoreController.setDistance(this, list);
            // Initializing new DrugStoreAdapter with list of drugstore
            final DrugStoreAdapter adapter = new DrugStoreAdapter(this, list);

            // Setting adapter to listView
            listView.setAdapter(adapter);

        } else {
            Toast.makeText(this, "Voce nao esta conectado ao gps ou a internet!\n Conecte-se para prosseguir.", Toast.LENGTH_LONG).show();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                list.get(position).setRate((float) 3.3);//this should be set as the httprequest
                drugStoreController.setDrugStore(list.get(position));
                //request from server the rate and set to the drugstore
                Intent intent = new Intent(getBaseContext(), DrugstoreScreen.class);

                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent nextScreen = new Intent(getBaseContext(), HospitalList.class);
                    //startActivity(nextScreen);
                    onBackPressed();


            }
        });
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_SCORE, mCurrentScore);
        savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
        mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
    }
}

