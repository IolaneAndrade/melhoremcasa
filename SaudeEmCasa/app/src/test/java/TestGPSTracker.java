//Teste para verificar se GPS está ligado

import android.content.Context;
import android.content.Intent;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.test.AndroidTestCase;
import android.util.Log;

import api.Helper.DatabaseHelper;
import mds.gpp.saudeemcasa.helper.GPSTracker;


/**
 * Created by vinisilvacar on 26/10/15.
 */
public class TestGPSTracker extends MyAndroidTestCase {

    boolean isGPSEnable = false;
    boolean isNetworkEnable = false;
    boolean canGetLocation = false;
    Location location;

    private DatabaseHelper dbHelper;

    protected LocationManager locationManager;
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final float MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

    @Override
    public void setUp() throws Exception {
        super.setUp();
        dbHelper = new DatabaseHelper(getContext());

    }

    public void testShouldPass() {
        Context context = getContext();
        GPSTracker gpsTracker = new GPSTracker(context);
        assertNotNull(gpsTracker);
    }


    public void testGetLocation(){
        Context context = getContext();
        GPSTracker gpsTracker = new GPSTracker(getContext());
        System.out.println("locationManager: "+ locationManager);
        System.out.println("context: "+ getContext());
        System.out.println("location_service: "+ Context.LOCATION_SERVICE);


        //locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // getting GPS status
        //isGPSEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // getting network status
        //isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        locationManager.setTestProviderLocation(LocationManager.NETWORK_PROVIDER, location);
        Log.d("Network", "Network");
        if (locationManager != null) {
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                location.setLongitude(12.3434);
                location.setLatitude(-15.3738);
            }
        }

        assertNotNull(location);

        assertTrue(isGPSEnable);

        assertTrue(canGetLocation);

        assertTrue(isNetworkEnable);

    }

    /*public void testCanGetLocation() throws Exception {

        String provider = Settings.Secure.getString(getContext().getContentResolver(),
        Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        assertNotNull(provider);
        //Se vier null ou length == 0   é por que o GPS esta desabilitado.
        //Para abrir a tela do menu pode fazer assim:
        //Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        //startActivityForResult(intent, 1);



    } */
}
