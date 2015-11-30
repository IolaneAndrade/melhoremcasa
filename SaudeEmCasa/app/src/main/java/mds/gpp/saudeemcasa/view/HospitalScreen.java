package mds.gpp.saudeemcasa.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.os.Looper;


import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.widget.Button;
import android.widget.RatingBar;


import android.support.v4.app.ActivityCompat;

import android.text.Html;

import android.view.View;
import android.widget.ImageButton;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RatingBar;

import android.widget.TextView;
import android.widget.Toast;

import api.Exception.ConnectionErrorException;
import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by freemanpivo on 11/14/15.
 */
public class HospitalScreen extends Fragment {

    View menu;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {

        View view = inflater.inflate(R.layout.hospital_screen, null);

        menu = view.findViewById(R.id.topbar_back);

        final HospitalController controller = HospitalController.getInstance(this.getContext());

        // setting name
        TextView nameTextView = (TextView) view.findViewById(R.id.textViewHospName);
        nameTextView.setText(controller.getHospital().getName());
        // Address
        TextView addressTextView = (TextView) view.findViewById(R.id.textViewAddressHosp);
        addressTextView.setText(Html.fromHtml(controller.getHospital().getAddress() + " - " + controller.getHospital().getCity() + " - " + controller.getHospital().getState()));
        // setting telephone
        TextView telephoneTextView = (TextView) view.findViewById(R.id.textViewHospTel);
        telephoneTextView.setText("Tel: " + controller.getHospital().getTelephone());





        Button hospitalButton = (Button) view.findViewById(R.id.buttonSaveRateHostpital);

        final RatingBar hospitalStars = (RatingBar) view.findViewById(R.id.ratingBarUserHospital);
        hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {

                    public void run() {
                        Looper.prepare();
                        try {
                            controller.updateRate((int) hospitalStars.getRating(), controller.getAndroidId(), controller.getHospital().getId());
                            Toast.makeText(getContext(),"Sua avaliação foi salva!",Toast.LENGTH_LONG).show();
                        } catch (ConnectionErrorException e) {
                            Toast.makeText(getContext(),"Houve um error de conexão.\nverifique se está conectado a internet.",Toast.LENGTH_LONG).show();
                        }

                        Looper.loop();
                    }
                }.start();
            }

        });

        //set ratting for drugstore
        RatingBar ratingBarFinal = (RatingBar) view.findViewById(R.id.ratingBarFinalHospital);
        ratingBarFinal.setRating(controller.getHospital().getRate());


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HospitalScreen.this, ChooseScreen.class); // essa é activity anterior do app
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // adiciona a flag para a intent
                //startActivity(intent);
            }
        });
            ImageButton phoneCallButton = (ImageButton) view.findViewById(R.id.phonecallButtonHospital);
            phoneCallButton.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) throws SecurityException{
                    Intent phoneCall = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+controller.getHospital().getTelephone()));

                    startActivity(phoneCall);

                }
            });

        return (view);

    }





}


