import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.view.LoadingScreen;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

/**
 * Created by lucas on 11/7/15.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestLoadingScreen extends ActivityInstrumentationTestCase2<LoadingScreen> {
    private LoadingScreen myActivity;

    @Rule
    public ActivityTestRule<LoadingScreen> mActivityRule = new ActivityTestRule(LoadingScreen.class);

    public TestLoadingScreen(Class<LoadingScreen> activityClass) {
        super(activityClass);
        this.myActivity = getActivity();

    }
    @Test
    public void testToListScreen(){
        onView(withId())
        myActivity.requestStablishment();

    }
}
