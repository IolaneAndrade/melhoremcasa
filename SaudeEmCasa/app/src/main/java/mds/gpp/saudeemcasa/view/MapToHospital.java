package mds.gpp.saudeemcasa.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.HospitalController;

public class MapToHospital extends Fragment {

    HospitalController controller = HospitalController.getInstance(this.getContext());

    //public MapToHospital() { }  // Required empty constructor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {

        View view = inflater.inflate(R.layout.hospital_screen, null);

        //HospitalController controller = HospitalController.getInstance(this);


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
        ratingBarFinal.setRating(controller.getHospital().

                        getRate()

        );

        TextView textViewRate = (TextView) view.findViewById(R.id.textViewRatingHospital);
        textViewRate.setText("" + controller.getHospital().

                        getRate()

        );

        return (view);
    }

}

