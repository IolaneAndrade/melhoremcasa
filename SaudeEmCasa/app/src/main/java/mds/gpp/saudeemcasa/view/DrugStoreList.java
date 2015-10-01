package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.os.Bundle;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.adapter.DrugStoreAdapter;
import mds.gpp.saudeemcasa.adapter.HospitalAdapter;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.model.DrugStore;

    ListView listView;
    List<DrugStore> listAdapterDrugStore;
    ArrayList<DrugStore> list;
    float[] distances;

public class DrugStoreList extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drugstore_list_screen);

        // Initialize and fill list of drugstore
        listAdapterDrugStore = DrugStoreController.getAllDrugStore();
        list = (ArrayList<DrugStore>) listAdapterDrugStore;
        distances = DrugStoreController.getDistance(this, list);

        // Initializing list view
        listView = (ListView) findViewById(R.id.listView);

        // Initializing new DrugStoreAdapter with list of drugstore
        if (distances != null) {
            DrugStoreAdapter adapter = new DrugStoreAdapter(this, list, distances);
            // Setting adapter to listView
            listView.setAdapter(adapter);
        } else {
            DrugStoreAdapterWhitoutGPS adapter = new DrugStoreAdapterWhitoutGPS(this, list);
            listView.setAdapter(adapter);
        }

    }
}
