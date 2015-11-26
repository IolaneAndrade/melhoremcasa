package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.adapter.HospitalAdapter;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Hospital;

import android.provider.Settings.Secure;
import android.widget.Toast;

import static java.security.AccessController.getContext;

/**
 * Created by lucas on 10/21/15.
 */
public class DrugstoreScreen extends FragmentActivity {

    ArrayList<DrugStore> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        System.out.println("ANDROID ID >>> " + androidId);

        /*
        * if (requestedId.equals(androidId)){
        *   print "VOCE JA VOTOU!"
        * else
        *   
        * */


        setContentView(R.layout.drugstore_screen);
        final DrugStoreController controller = DrugStoreController.getInstance(this);
        final DrugStore drugStore = controller.getDrugstore();
        // setting name
        TextView nameTextView = (TextView)findViewById(R.id.textViewDrugName);
        nameTextView.setText(drugStore.getName());
        // Address
        TextView addressTextView = (TextView)findViewById(R.id.textViewAddress);
        addressTextView.setText(Html.fromHtml(drugStore.getAddress() + " - " + drugStore.getCity() + " - " + drugStore.getState()));
        //CEP
        TextView cepTextView = (TextView)findViewById(R.id.textViewCep);
        cepTextView.setText("Cep: " + drugStore.getPostalCode());
        // setting telephone
        if(drugStore.getType().equals("FARMACIAPOPULAR")){
            TextView telephoneTextView = (TextView) findViewById(R.id.textViewDrugTel);
            telephoneTextView.setText("");
        }else {
            TextView telephoneTextView = (TextView) findViewById(R.id.textViewDrugTel);
            telephoneTextView.setText("Tel: " + drugStore.getTelephone());
        }

        //set ratting for drugstore
        RatingBar ratingBarFinal = (RatingBar)findViewById(R.id.ratingBarFinalDrugstore);
        ratingBarFinal.setRating(drugStore.getRate());

        TextView textViewRate = (TextView)findViewById(R.id.textViewRatingDrugstore);
        textViewRate.setText("" + drugStore.getRate());

        Button drugStoreButton = (Button) findViewById(R.id.buttonSaveRateDrugstore);
        drugStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                controller.updateRate(drugStore.getRate(), androidId, drugStore.getId());
            }
        });

        Button drugStoreMapButton = (Button) findViewById(R.id.button_drugstore_map);

        drugStoreMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextScreen = new Intent(getBaseContext(), GoogleMapDrugStore.class);
                startActivity(nextScreen);
            }

        });

    }
}

