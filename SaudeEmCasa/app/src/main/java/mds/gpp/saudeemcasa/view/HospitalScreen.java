package mds.gpp.saudeemcasa.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.HospitalController;



/**
 * Created by freemanpivo on 11/14/15.
 */
public class HospitalScreen extends FragmentActivity {

    HospitalController controller = HospitalController.getInstance(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_screen);

        // setting name
        TextView nameTextView = (TextView) findViewById(R.id.textViewHospName);
        nameTextView.setText(controller.getHospital().getName());

        // Address
        TextView addressTextView = (TextView) findViewById(R.id.textViewAddressHosp);
        addressTextView.setText(Html.fromHtml(controller.getHospital().

                        getAddress()

                        + " - " + controller.getHospital().

                        getCity()

                        + " - " + controller.getHospital().

                        getState()

        ));
        // setting telephone
        TextView telephoneTextView = (TextView) findViewById(R.id.textViewHospTel);
        telephoneTextView.setText("Tel: " + controller.getHospital().

                        getTelephone()

        );

        //set ratting for drugstore
        RatingBar ratingBarFinal = (RatingBar) findViewById(R.id.ratingBarFinalHospital);
        ratingBarFinal.setRating(controller.getHospital().getRate());

        TextView textViewRate = (TextView) findViewById(R.id.textViewRatingHospital);
        textViewRate.setText("" + controller.getHospital().

                        getRate()

        );

        Button hospitalMapButton = (Button) findViewById(R.id.button_hospital_map);

        hospitalMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), GoogleMapHospital.class);
                startActivity(intent);
            }
        });

    }
}


