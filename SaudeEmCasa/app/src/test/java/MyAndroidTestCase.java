import android.content.Context;
import android.os.SystemClock;
import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

/**
 * Created by vinisilvacar on 23/10/15.
 */
public class MyAndroidTestCase extends AndroidTestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
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
