//Teste para verificar se GPS está pegando a Localização di usuário

//Mudar para o Instrumment Test Case
// Criar activity (tela) para rodar

//Build Variantes - AndroidInstrumentation tests

//

import android.app.Instrumentation;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.view.LoadingScreen;

/**
 * Created by vinisilvacar on 26/10/15.
 */
public class TestGPSTracker extends ActivityInstrumentationTestCase2<LoadingScreen> {
    protected LocationManager locationManager;
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final float MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute


    boolean isGPSEnable = false;
    boolean isNetworkEnable = false;
    boolean canGetLocation = false;
    Location location;

    private LoadingScreen myActivity;
    private Instrumentation myInstrumentation;
    GPSTracker gpsTracker;

    public TestGPSTracker() {
        super(LoadingScreen.class);
    }


    protected void setUp() throws Exception {
        super.setUp();
        this.myActivity = getActivity();
        this.myInstrumentation = getInstrumentation();
        gpsTracker = new GPSTracker(myActivity.getApplicationContext());

    }

    public void testShouldPass() {
        GPSTracker gpsTracker = new GPSTracker(myActivity.getApplicationContext());
        assertNotNull(gpsTracker);
    }

    public void testGetLocation(){
        GPSTracker gpsTracker = new GPSTracker(myActivity.getApplicationContext());
        assertNotNull(gpsTracker);

        locationManager = (LocationManager) myActivity.getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        // getting GPS status
        isGPSEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // getting network status
        isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        locationManager.setTestProviderLocation(locationManager.NETWORK_PROVIDER, location);
        Log.d("Network", "Network");
        if (locationManager != null) {
            //location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                location.setLongitude(12.3434);
                location.setLatitude(-15.3738);
            }
        }



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
