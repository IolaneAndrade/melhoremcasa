package Controller;

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestResult;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import api.Exception.ConnectionErrorException;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Stablishment;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.view.LoadingScreen;


import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by iolane on 30/10/15.
 */
public class TestDrugStoreController extends ActivityInstrumentationTestCase2<LoadingScreen> {
    private LoadingScreen myActivity;

    public TestDrugStoreController(Class<LoadingScreen> activityClass) {
        super(activityClass);
    }


//    @Test
//    public void testDistance() {}

        /*
        GPSTracker gps = new GPSTracker();

        DrugStoreController phone = new DrugStoreController();
        double userLatitude = gps.getLatitude();
        double userLongitude = gps.getLongitude();
        */


        //haversine_km2
        //Stablishment distances = new Stablishment(42.124891, -71.062251);
        //double distance = distances.getDistance(phone.getLatitude(), phone.getLongitude());
/*
        @Test
        public void testDistanceList () {}

            public static <DrugStore> boolean areEqualIgnoringOrder
            (List < DrugStore > listDistancesDrugStoreOrigin, List < DrugStore > listDistancesDrugStoreCompare, Comparator< ? super
                        DrugStore > comparator){

                List<DrugStore> listDistancesDrugStoreOrigin = new ArrayList<>(listDistancesDrugStoreOrigin);
                List<DrugStore> listDistancesDrugStoreCompare = new ArrayList<>(listDistancesDrugStoreCompare);

            }

            @Test
            public void testListDrugStore () {

            }
    */

        public void testInitControllerDrugStore() {
            DrugStoreController drugStoreController = DrugStoreController.getInstance(myActivity.getApplicationContext());
            try {
                drugStoreController.initControllerDrugstore();
                assertTrue(drugStoreController.getAllDrugstores().size() > 0);
            } catch (IOException e) {
                fail();
            } catch (JSONException e) {
                fail();
            } catch (ConnectionErrorException e) {
                fail();
            }
            assertTrue(true);

        }


    }

