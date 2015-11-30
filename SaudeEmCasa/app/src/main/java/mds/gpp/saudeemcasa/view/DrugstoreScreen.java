package mds.gpp.saudeemcasa.view;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.model.DrugStore;


/**
 * Created by lucas on 10/21/15.
 */
public class DrugstoreScreen extends Fragment {

    ArrayList<DrugStore> list;
    View menu;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {

        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            menu = findViewById(R.id.topbar_back);

            final String androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            View view = inflater.inflate(R.layout.drugstore_screen, null);


        /*final String androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        System.out.println("ANDROID ID >>> " + androidId);*/

        /*
        * if (requestedId.equals(androidId)){
        *   print "VOCE JA VOTOU!"
        * else
        *   
        * */

            final DrugStoreController controller = DrugStoreController.getInstance(this.getContext());
            final DrugStore drugStore = controller.getDrugstore();
            // setting name
            TextView nameTextView = (TextView) view.findViewById(R.id.textViewDrugName);
            nameTextView.setText(drugStore.getName());
            // Address
            TextView addressTextView = (TextView) view.findViewById(R.id.textViewAddress);
            addressTextView.setText(Html.fromHtml(drugStore.getAddress() + " - " + drugStore.getCity() + " - " + drugStore.getState()));
            //CEP
            TextView cepTextView = (TextView) view.findViewById(R.id.textViewCep);
            cepTextView.setText("Cep: " + drugStore.getPostalCode());
            // setting telephone

            if (drugStore.getType().equals("FARMACIAPOPULAR")) {
                TextView telephoneTextView = (TextView) view.findViewById(R.id.textViewDrugTel);
                telephoneTextView.setText("Não possui telefone");
            } else {
                TextView telephoneTextView = (TextView) view.findViewById(R.id.textViewDrugTel);
                telephoneTextView.setText("Tel: " + drugStore.getTelephone());
            }

            //set ratting for drugstore
            RatingBar ratingBarFinal = (RatingBar) view.findViewById(R.id.ratingBarFinalDrugstore);
            ratingBarFinal.setRating(drugStore.getRate());

            TextView textViewRate = (TextView) view.findViewById(R.id.textViewRatingDrugstore);
            textViewRate.setText("" + drugStore.getRate());

        /*Button drugStoreButton = (Button) view.findViewById(R.id.buttonSaveRateDrugstore);
        drugStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                controller.updateRate(drugStore.getRate(), androidId, drugStore.getId());
<<<<<<< HEAD
            }
        });


    }

    private void setPhoneCallListenner(final String telephone) {
        ImageButton phoneCallButton = (ImageButton) findViewById(R.id.phonecallButtonDrugstore);
        phoneCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws SecurityException{

                Intent phoneCall = new Intent(Intent.ACTION_CALL);
                phoneCall.setData(Uri.parse("tel:" + telephone));
                startActivity(phoneCall);

            }
        });

=======
            }
        });*/
        }
    }

}

