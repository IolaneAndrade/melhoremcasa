package mds.gpp.saudeemcasa.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.wearable.view.DismissOverlayView;
import android.text.Html;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.controller.HospitalController;


/**
 * Created by freemanpivo on 11/14/15.
 */
public class HospitalScreen extends FragmentActivity /*implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener */{

    private GoogleMap mMap;

   /* public HospitalScreen(DismissOverlayView mDismissOverlay) {
        this.mDismissOverlay = mDismissOverlay;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hospital_screen);
        HospitalController controller = HospitalController.getInstance(this);

        setContentView(R.layout.activity_hospital_maps);
        setUpMapIfNeeded();

        //setContentView(R.layout.hospital_map);

        /*
        SupportMapFragment fragment = (SupportMapFragment)

        getSupportFragmentManager().findFragmentById(R.id.hospital_map);
        fragment.getMapAsync(this);

        mDismissOverlay = (DismissOverlayView) findViewById(R.id.dismiss_overlay);
        mDismissOverlay.setIntroText("ERROR");
        mDismissOverlay.showIntroIfNecessary();


        //googleMap = fragment.getMap();
        //googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        //originLocation = new LatLng(-23.561706, -46.655981);
        // controller.updateGoogleMap();
        */

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
        ratingBarFinal.setRating(controller.getHospital().

                        getRate()

        );

        TextView textViewRate = (TextView) findViewById(R.id.textViewRatingHospital);
        textViewRate.setText("" + controller.getHospital().

                        getRate()

        );


    }

    /*
    private GoogleMap mMap;
    private static final LatLng SYDNEY = new LatLng(-33.85704, 151.21522);
    private DismissOverlayView mDismissOverlay;

    @Override
    public void onMapReady (GoogleMap map){
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Map is ready to be used.
        mMap = googleMap;

        // Set the long click listener as a way to exit the map.
        mMap.setOnMapLongClickListener(this);

        // Add a marker with a title that is shown in its info window.
        mMap.addMarker(new MarkerOptions().position(SYDNEY)
                .title("Sydney Opera House"));

        // Move the camera to show the marker.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SYDNEY, 10));
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

        mDismissOverlay.show();

    }*/

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}


