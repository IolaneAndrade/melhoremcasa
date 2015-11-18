package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.HospitalController;


/**
 * Created by freemanpivo on 11/14/15.
 */
public class HospitalScreen extends FragmentActivity {

    SupportMapFragment fragmentMap;
    GoogleMap googleMap;

    HospitalController controller = HospitalController.getInstance(this);
    LatLng originLocation;


    @Override

    public void onResume() {
        super.onResume();

        new Thread(){
            public void run() {
                while (fragmentMap.getMap() == null);
                try {
                    runOnUiThread (new Runnable() {
                        @Override
                        public void run() {
                            configMap();
                        }
                    });
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();

    }

    public void configMap() {
        googleMap = fragmentMap.getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        controller.updateGoogleMap();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SupportMapFragment fragment = SupportMapFragment.newInstance();
                getSupportFragmentManager().findFragmentById(R.id.hospital_map);

        //googleMap = fragment.getMap();
        //googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        //originLocation = new LatLng(-23.561706, -46.655981);
       // controller.updateGoogleMap();


        setContentView(R.layout.hospital_screen);
        HospitalController controller = HospitalController.getInstance(this);
        
        // setting name
        TextView nameTextView = (TextView)findViewById(R.id.textViewHospName);
        nameTextView.setText(controller.getHospital().getName());
        // Address
        TextView addressTextView = (TextView)findViewById(R.id.textViewAddressHosp);
        addressTextView.setText(Html.fromHtml(controller.getHospital().getAddress() + " - " + controller.getHospital().getCity() + " - " + controller.getHospital().getState()));
        // setting telephone
            TextView telephoneTextView = (TextView) findViewById(R.id.textViewHospTel);
            telephoneTextView.setText("Tel: " + controller.getHospital().getTelephone());

        //set ratting for drugstore
        RatingBar ratingBarFinal = (RatingBar)findViewById(R.id.ratingBarFinalHospital);
        ratingBarFinal.setRating(controller.getHospital().getRate());

        TextView textViewRate = (TextView)findViewById(R.id.textViewRatingHospital);
        textViewRate.setText(""+controller.getHospital().getRate());


    }

}
