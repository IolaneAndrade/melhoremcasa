package mds.gpp.saudeemcasa.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.Html;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.RatingBar;

import android.widget.TextView;
import android.widget.Toast;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by freemanpivo on 11/14/15.
 */
public class HospitalScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_screen);
        HospitalController controller = HospitalController.getInstance(this);
        
        // setting name
        TextView nameTextView = (TextView) findViewById(R.id.textViewHospName);
        nameTextView.setText(controller.getHospital().getName());
        // Address
        TextView addressTextView = (TextView) findViewById(R.id.textViewAddressHosp);
        addressTextView.setText(Html.fromHtml(controller.getHospital().getAddress() + " - " + controller.getHospital().getCity() + " - " + controller.getHospital().getState()));
        // setting telephone
        TextView telephoneTextView = (TextView) findViewById(R.id.textViewHospTel);
        telephoneTextView.setText("Tel: " + controller.getHospital().getTelephone());
        //set ratting for drugstore
        RatingBar ratingBarFinal = (RatingBar)findViewById(R.id.ratingBarFinalHospital);
        ratingBarFinal.setRating(controller.getHospital().getRate());

        TextView textViewRate = (TextView)findViewById(R.id.textViewRatingHospital);
        textViewRate.setText(""+controller.getHospital().getRate());

        setPhoneCallListenner(controller.getHospital().getTelephone());
    }

    private void setPhoneCallListenner(final String telephone) {
        ImageButton phoneCallButton = (ImageButton) findViewById(R.id.phonecallButtonHospital);
        phoneCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws SecurityException {

                Intent phoneCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telephone));


                startActivity(phoneCall);

            }
        });



    }

}
