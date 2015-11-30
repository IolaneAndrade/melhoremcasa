package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.list_screen_activity);

        // Initializing list view
        listView = (ListView) findViewById(R.id.listView);

        menu = findViewById(R.id.topbar_back);

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
                Intent intent = new Intent(DrugStoreList.this, ChooseScreen.class); // essa é activity Inicial do app
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // adiciona a flag para a intent
                startActivity(intent);
            }
        });
    }


}