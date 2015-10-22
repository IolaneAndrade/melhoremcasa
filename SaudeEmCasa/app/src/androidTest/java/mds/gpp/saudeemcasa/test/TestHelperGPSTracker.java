package mds.gpp.saudeemcasa.test;

import android.location.Location;
import android.location.LocationManager;

import junit.framework.TestCase;

/**
 * Created by vinisilvacar on 22/10/15.
 */
public class TestHelperGPSTracker extends TestCase {
    protected LocationManager locationManager;
    double longitude;
    double latitude;
    Location location;

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testGetLocation() throws Exception {
        location.setLatitude(-15.4647);
        location.setLongitude(47.5547);
        assertEquals(location.getLatitude(), -15.4647);

    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
