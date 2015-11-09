package Controller;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.List;

import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Stablishment;
import mds.gpp.saudeemcasa.view.DrugStoreList;
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

        public void testDistanceComparator() throws Exception{
            DrugStoreController drugStoreController = DrugStoreController.getInstance(myActivity.getApplicationContext());

            List<Stablishment> drugStoreList = new ArrayList<Stablishment>();

            Stablishment drugStore1 = new Stablishment("Farmacia Pague Menos", 33);
            Stablishment drugStore2 = new Stablishment("Farmacia Globo", 25);
            Stablishment drugStore3 = new Stablishment("Farmacia São Bernardo", 50);
            Stablishment drugStore4 = new Stablishment("Farmacia Lene", 14);
            Stablishment drugStore5 = new Stablishment("Farmacia Oliveira", 7);

            drugStoreList.add(drugStore1);
            drugStoreList.add(drugStore2);
            drugStoreList.add(drugStore3);
            drugStoreList.add(drugStore4);
            drugStoreList.add(drugStore5);

            drugStoreList = drugStoreController.DistanceComparator(drugStoreList);

            List<Stablishment> drugStoreListToCompare = new ArrayList<Stablishment>();

            drugStoreListToCompare.add(drugStore5);
            drugStoreListToCompare.add(drugStore4);
            drugStoreListToCompare.add(drugStore2);
            drugStoreListToCompare.add(drugStore1);
            drugStoreListToCompare.add(drugStore3);


            assertSame(drugStoreList, drugStoreListToCompare);

            myActivity.finish();
        }


       /* public void  testSetDistanceControllerDrugStore() throws Exception {
            DrugStoreController drugStoreController = DrugStoreController.getInstance(myActivity.getApplicationContext());
            GPSTracker gps = new GPSTracker(this);
            ArrayList<DrugStore> listTest;
            listTest = drugStoreController.getAllDrugstores();
            drugStoreController.oganizeListDrugStoreForDistance();
            myActivity.finish();


        }*/



    }


