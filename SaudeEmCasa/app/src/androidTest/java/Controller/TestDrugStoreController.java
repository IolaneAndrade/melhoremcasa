package Controller;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.List;

import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.model.Stablishment;
import mds.gpp.saudeemcasa.view.LoadingScreen;

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

        public void testInitControllerDrugStore() throws Exception {

            DrugStoreController drugStoreController = DrugStoreController.getInstance(myActivity.getApplicationContext());

            drugStoreController.initControllerDrugstore();
            assertTrue(drugStoreController.getAllDrugstores().size() > 0);
            myActivity.finish();

        }
/*
        public void testDistanceComparator() throws Exception{
            DrugStoreController drugStoreController = DrugStoreController.getInstance(myActivity.getApplicationContext());
            drugStoreController.DistanceComparator();

            List<Stablishment> drugStoreList = new ArrayList<Stablishment>();

            Stablishment drugStore1 = new Stablishment("Rosario", "3385-9790", 3.5);
            Stablishment drugStore2= new Stablishment("Pague Menos", "3332-1232", 7.8);
            Stablishment drugStore3 = new Stablishment("Pacheco", "35556767");
            Stablishment drugStore4 = new Stablishment("Posto nº 06", "3234-0001", 9.75);
            Stablishment drugStore5 = new Stablishment("Drogasil", "35569480", 2.55);

            drugStoreList.add(drugStore1);
            drugStoreList.add(drugStore2);
            drugStoreList.add(drugStore3);
            drugStoreList.add(drugStore4);
            drugStoreList.add(drugStore5);

            myActivity.finish();
        }

        public void  testSetDistanceControllerDrugStore() throws Exception {
            DrugStoreController drugStoreController = DrugStoreController.getInstance(myActivity.getApplicationContext());

            drugStoreController.oganizeListDrugStoreForDistance();
            myActivity.finish();


        }
        */



    }


