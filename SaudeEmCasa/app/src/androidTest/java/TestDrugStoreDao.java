import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import api.Dao.DrugStoreDao;
import mds.gpp.saudeemcasa.view.LoadingScreen;

/**
 * Created by vinisilvacar on 02/11/15.
 */
public class TestDrugStoreDao extends ActivityInstrumentationTestCase2<LoadingScreen> {
    private LoadingScreen myActivity;
    private Instrumentation myInstrumentation;
    DrugStoreDao drugStoreDao;

    public TestDrugStoreDao() {
        super(LoadingScreen.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.myActivity = getActivity();
        this.myInstrumentation = getInstrumentation();
        drugStoreDao = DrugStoreDao.getInstance(myActivity.getApplicationContext());
        assertNotNull(drugStoreDao);
    }


}
