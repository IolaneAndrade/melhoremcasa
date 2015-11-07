package Activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mds.gpp.saudeemcasa.view.LoadingScreen;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by freemanpivo on 10/31/15.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest

public class TestLoadingScreen {
    @Rule
    public ActivityTestRule<LoadingScreen> mActivityRule = new ActivityTestRule<>(LoadingScreen.class);

    @Test
    public void listGoesOverTheFold() {
        onView(withText("Hello world!")).check(matches(isDisplayed()));
    }
}
