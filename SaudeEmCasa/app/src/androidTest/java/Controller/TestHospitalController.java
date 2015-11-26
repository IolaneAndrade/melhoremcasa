package Controller;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import api.Exception.ConnectionErrorException;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.model.Hospital;
import mds.gpp.saudeemcasa.view.LoadingScreen;

/**
 * Created by iolane on 15/11/15.
 */
public class TestHospitalController extends ActivityInstrumentationTestCase2<LoadingScreen> {

        private LoadingScreen myActivity;
        private Instrumentation myInstrumentation;
        HospitalController hospitalController;

        public TestHospitalController() {
            super(LoadingScreen.class);
        }

        protected void setUp() throws Exception {
            super.setUp();
            this.myActivity = getActivity();
            this.myActivity = getActivity();
            this.myInstrumentation = getInstrumentation();
            hospitalController = HospitalController.getInstance(myActivity.getApplicationContext());

        }

    public void tearDown(){
        hospitalController.getHospitalDao().deleteAllHospitals();

    }

/*        public void testInitControllerHospital() {

            try {
                hospitalController.initControllerHospital();
            } catch (IOException e) {
                fail();
            } catch (JSONException e) {
                fail();
            } catch (ConnectionErrorException e) {
                fail();
            }
            assertTrue(hospitalController.getAllHospitals().size() > 0);
            myActivity.finish();

        }

        public void testInitControllerHospitalFalse() {

            try {
                hospitalController.initControllerHospital();
            } catch (IOException e) {
                fail();
            } catch (JSONException e) {
                fail();
            } catch (ConnectionErrorException e) {
                fail();
            }
            assertFalse(hospitalController.getAllHospitals().size() < 0);
            myActivity.finish();

        }*/

    public void testOrganizeListHospitalForDistance() throws Exception{

        ArrayList<Hospital> hospitalArrayList = new ArrayList<Hospital>();

        Hospital hospital1 = new Hospital();
        hospital1.setLatitude("16.00");
        hospital1.setLongitude("48.00");
        Hospital hospital2 = new Hospital();
        hospital2.setLatitude("16.00");
        hospital2.setLongitude("60.00");
        Hospital hospital3 = new Hospital();
        hospital3.setLatitude("16.00");
        hospital3.setLongitude("58.00");
        Hospital hospital4 = new Hospital();
        hospital4.setLatitude("16.00");
        hospital4.setLongitude("73.00");
        Hospital hospital5 = new Hospital();
        hospital5.setLatitude("16.00");
        hospital5.setLongitude("49.00");

        hospitalArrayList.add(hospital1);
        hospitalArrayList.add(hospital2);
        hospitalArrayList.add(hospital3);
        hospitalArrayList.add(hospital4);
        hospitalArrayList.add(hospital5);

        hospitalController.setHospitalList(hospitalArrayList);
        hospitalController.oganizeListHospitalForDistance();

        ArrayList<Hospital> hospitalListToCompare = new ArrayList<Hospital>();

        hospitalListToCompare.add(hospital1);
        hospitalListToCompare.add(hospital5);
        hospitalListToCompare.add(hospital3);
        hospitalListToCompare.add(hospital2);
        hospitalListToCompare.add(hospital4);

        assertTrue(hospitalListToCompare.get(2).getLongitude() == hospitalController.getAllHospitals().get(2).getLongitude());

        myActivity.finish();

    }

    public void testOrganizeListHospitalForDistanceFalse() throws Exception{

        ArrayList<Hospital> hospitalArrayList = new ArrayList<Hospital>();

        Hospital hospital1 = new Hospital();
        hospital1.setLatitude("16.00");
        hospital1.setLongitude("48.00");
        Hospital hospital2 = new Hospital();
        hospital2.setLatitude("16.00");
        hospital2.setLongitude("60.00");
        Hospital hospital3 = new Hospital();
        hospital3.setLatitude("16.00");
        hospital3.setLongitude("58.00");
        Hospital hospital4 = new Hospital();
        hospital4.setLatitude("16.00");
        hospital4.setLongitude("73.00");
        Hospital hospital5 = new Hospital();
        hospital5.setLatitude("16.00");
        hospital5.setLongitude("49.00");

        hospitalArrayList.add(hospital1);
        hospitalArrayList.add(hospital2);
        hospitalArrayList.add(hospital3);
        hospitalArrayList.add(hospital4);
        hospitalArrayList.add(hospital5);

        hospitalController.setHospitalList(hospitalArrayList);
        hospitalController.oganizeListHospitalForDistance();

        ArrayList<Hospital> hospitalListToCompare = new ArrayList<Hospital>();

        hospitalListToCompare.add(hospital1);
        hospitalListToCompare.add(hospital5);
        hospitalListToCompare.add(hospital3);
        hospitalListToCompare.add(hospital2);
        hospitalListToCompare.add(hospital4);

        assertFalse(hospitalListToCompare.get(3).getLongitude() == hospitalController.getAllHospitals().get(2).getLongitude());

        myActivity.finish();

    }
}
