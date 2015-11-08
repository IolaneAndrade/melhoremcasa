package Controller;

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestResult;

import android.app.Instrumentation;
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
    private Instrumentation myInstrumentation;
    DrugStoreController drugStoreController;

    public TestDrugStoreController() {
        super(LoadingScreen.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.myActivity = getActivity();
        this.myActivity = getActivity();
        this.myInstrumentation = getInstrumentation();
        drugStoreController = DrugStoreController.getInstance(myActivity.getApplicationContext());
    }

        @Test
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


