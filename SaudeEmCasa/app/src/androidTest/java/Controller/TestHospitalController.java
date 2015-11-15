package Controller;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import api.Exception.ConnectionErrorException;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.controller.HospitalController;
import mds.gpp.saudeemcasa.model.DrugStore;
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
            hospitalController.getAllHospitals().deleteAllHospitals();
        }

        public void testInitControllerHospital() {

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


}
