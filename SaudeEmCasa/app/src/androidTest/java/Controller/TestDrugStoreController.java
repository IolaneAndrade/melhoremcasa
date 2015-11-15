package Controller;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.Exception.ConnectionErrorException;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.model.DrugStore;
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

    public void tearDown() {
        drugStoreController.getDrugStoreDao().deleteAllDrugStores();

    }

    public void testInitControllerDrugStore() {

        try {
            drugStoreController.initControllerDrugstore();
        } catch (IOException e) {
            fail();
        } catch (JSONException e) {
            fail();
        } catch (ConnectionErrorException e) {
            fail();
        }
        assertTrue(drugStoreController.getAllDrugstores().size() > 0);
        myActivity.finish();

    }

    public void testInitControllerDrugStoreFalse() {

        try {
            drugStoreController.initControllerDrugstore();
        } catch (IOException e) {
            fail();
        } catch (JSONException e) {
            fail();
        } catch (ConnectionErrorException e) {
            fail();
        }
        assertFalse(drugStoreController.getAllDrugstores().size() < 0);
        myActivity.finish();

    }


    public void testOrganizeListDrugStoreForDistance() throws Exception {

        ArrayList<DrugStore> drugStoreList = new ArrayList<DrugStore>();

        DrugStore drugStore1 = new DrugStore();
        drugStore1.setLatitude("16.00");
        drugStore1.setLongitude("48.00");
        DrugStore drugStore2 = new DrugStore();
        drugStore2.setLatitude("16.00");
        drugStore2.setLongitude("60.00");
        DrugStore drugStore3 = new DrugStore();
        drugStore3.setLatitude("16.00");
        drugStore3.setLongitude("58.00");
        DrugStore drugStore4 = new DrugStore();
        drugStore4.setLatitude("16.00");
        drugStore4.setLongitude("73.00");
        DrugStore drugStore5 = new DrugStore();
        drugStore5.setLatitude("16.00");
        drugStore5.setLongitude("49.00");

        drugStoreList.add(drugStore1);
        drugStoreList.add(drugStore2);
        drugStoreList.add(drugStore3);
        drugStoreList.add(drugStore4);
        drugStoreList.add(drugStore5);

        drugStoreController.setDrugStoreList(drugStoreList);
        drugStoreController.oganizeListDrugStoreForDistance();

        ArrayList<DrugStore> drugStoreListToCompare = new ArrayList<DrugStore>();

        drugStoreListToCompare.add(drugStore1);
        drugStoreListToCompare.add(drugStore5);
        drugStoreListToCompare.add(drugStore3);
        drugStoreListToCompare.add(drugStore2);
        drugStoreListToCompare.add(drugStore4);

        assertTrue(drugStoreListToCompare.get(2).getLongitude() == drugStoreController.getAllDrugstores().get(2).getLongitude());

        myActivity.finish();

    }

    public void testOrganizeListDrugStoreForDistanceFalse() throws Exception{

        ArrayList<DrugStore> drugStoreList = new ArrayList<DrugStore>();

        DrugStore drugStore1 = new DrugStore();
        drugStore1.setLatitude("16.00");
        drugStore1.setLongitude("48.00");
        DrugStore drugStore2 = new DrugStore();
        drugStore2.setLatitude("16.00");
        drugStore2.setLongitude("60.00");
        DrugStore drugStore3 = new DrugStore();
        drugStore3.setLatitude("16.00");
        drugStore3.setLongitude("58.00");
        DrugStore drugStore4 = new DrugStore();
        drugStore4.setLatitude("16.00");
        drugStore4.setLongitude("73.00");
        DrugStore drugStore5 = new DrugStore();
        drugStore5.setLatitude("16.00");
        drugStore5.setLongitude("49.00");

        drugStoreList.add(drugStore1);
        drugStoreList.add(drugStore2);
        drugStoreList.add(drugStore3);
        drugStoreList.add(drugStore4);
        drugStoreList.add(drugStore5);

        drugStoreController.setDrugStoreList(drugStoreList);
        drugStoreController.oganizeListDrugStoreForDistance();

        ArrayList<DrugStore> drugStoreListToCompare = new ArrayList<DrugStore>();

        drugStoreListToCompare.add(drugStore1);
        drugStoreListToCompare.add(drugStore5);
        drugStoreListToCompare.add(drugStore3);
        drugStoreListToCompare.add(drugStore2);
        drugStoreListToCompare.add(drugStore4);

        assertFalse(drugStoreListToCompare.get(3).getLongitude() == drugStoreController.getAllDrugstores().get(2).getLongitude());

        myActivity.finish();

    }

}




