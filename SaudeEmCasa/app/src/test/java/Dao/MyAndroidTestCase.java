import android.app.Instrumentation;
import android.content.Context;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

import api.Dao.DrugStoreDao;
import mds.gpp.saudeemcasa.view.LoadingScreen;

/**
 * Created by vinisilvacar on 23/10/15.
 */
public class MyAndroidTestCase extends ActivityInstrumentationTestCase2<LoadingScreen> {
    private LoadingScreen myActivity;
    private Instrumentation myInstrumentation;
    DrugStoreDao drugStoreDao;

    public MyAndroidTestCase() {
        super(LoadingScreen.class);
    }


    protected void setUp() throws Exception {
        super.setUp();
        this.myActivity = getActivity();
        this.myInstrumentation = getInstrumentation();
        drugStoreDao = new DrugStoreDao.getInstance(myActivity.getApplicationContext());

    }

    @Override
    public void setContext(Context context){
        super.setContext(context);

        long endTime = SystemClock.elapsedRealtime() + TimeUnit.SECONDS.toMillis(2);

        while(null == context.getApplicationContext()){
            if(SystemClock.elapsedRealtime() >= endTime){
                fail();
            }
        }

        SystemClock.sleep(16);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
