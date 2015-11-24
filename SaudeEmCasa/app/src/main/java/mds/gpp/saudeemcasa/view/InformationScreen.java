package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by vinisilvacar on 24/11/15.
 */
public class InformationScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.information_screen);

        // Setting name Saude em Casa
        TextView nameTextViewSC = (TextView)findViewById(R.id.textViewSaudeEmCasaInformation);
        nameTextViewSC.setText("Saúde em Casa");
        /* Address
        TextView addressTextView = (TextView)findViewById(R.id.textViewAddress);
        addressTextView.setText(Html.fromHtml(drugStore.getAddress() + " - " + drugStore.getCity() + " - " + drugStore.getState()));
        */

        // Setting name Melhor em Casa
        TextView nameTextViewMC = (TextView)findViewById(R.id.textViewMelhorEmCasaInformation);
        nameTextViewMC.setText("Melhor em Casa");

        // Setting name Farmacia Popular
        TextView nameTextViewFP = (TextView)findViewById(R.id.textViewFarmaciaPopularInformation);
        nameTextViewFP.setText("Farmácia Popular");

    }
}
