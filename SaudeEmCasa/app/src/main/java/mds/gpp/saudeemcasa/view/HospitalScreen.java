package mds.gpp.saudeemcasa.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.HospitalController;

/**
 * Created by freemanpivo on 11/14/15.
 */
public class HospitalScreen extends Fragment {

    HospitalController controller = HospitalController.getInstance(this.getContext());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {

        View view = inflater.inflate(R.layout.hospital_screen, null);

        // setting name
        TextView nameTextView = (TextView) view.findViewById(R.id.textViewHospName);
        nameTextView.setText(controller.getHospital().getName());

        // Address
        TextView addressTextView = (TextView) view.findViewById(R.id.textViewAddressHosp);
        addressTextView.setText(Html.fromHtml(controller.getHospital().

                        getAddress()

                        + " - " + controller.getHospital().

                        getCity()

                        + " - " + controller.getHospital().

                        getState()

        ));
        // setting telephone
        TextView telephoneTextView = (TextView) view.findViewById(R.id.textViewHospTel);
        telephoneTextView.setText("Tel: " + controller.getHospital().

                        getTelephone()

        );

        //set ratting for drugstore
        RatingBar ratingBarFinal = (RatingBar) view.findViewById(R.id.ratingBarFinalHospital);
        ratingBarFinal.setRating(controller.getHospital().getRate());

        TextView textViewRate = (TextView) view.findViewById(R.id.textViewRatingHospital);
        textViewRate.setText("" + controller.getHospital().

                        getRate()

        );

        /*Button hospitalMapButton = (Button) findViewById(R.id.button_hospital_map);

        hospitalMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), GoogleMapHospital.class);
                startActivity(intent);
            }
        });*/
        return (view);
    }
}


