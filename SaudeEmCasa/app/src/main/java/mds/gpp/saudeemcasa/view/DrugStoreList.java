package mds.gpp.saudeemcasa.view;

import android.app.ActionBar;
import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.adapter.DrugStoreAdapter;
import mds.gpp.saudeemcasa.adapter.HospitalAdapter;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Hospital;


public class DrugStoreList extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drugstore_list_screen);

        // Initializing fake drugstore
        DrugStore d1 = new DrugStore("Farmácia de Sao Bernardo", "(61) 3321-8181");
        DrugStore d2 = new DrugStore("Farmácia Santa Marta", "(61) 3321-8080");
        DrugStore d3 = new DrugStore("Farmácia PagueMenos", "(61) 3321-8000");
        DrugStore d4 = new DrugStore("Farmácia Guadalupe", "(61) 3321-5151");
        DrugStore d5 = new DrugStore("Farmácia São Francisco", "(61) 3321-0000");

        // Initializing list view
        listView = (ListView) findViewById(R.id.listView);

        // Initialize and fill list of drugstore
        ArrayList<DrugStore> lista = new ArrayList<DrugStore>();
        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);
        lista.add(d5);

        // Initializing new DrugStoreAdapter with list of drugstore
        DrugStoreAdapter adapter = new DrugStoreAdapter(this,lista);

        // Setting adapter to listView
        listView.setAdapter(adapter);

    }
}
