package View;

        import android.test.ActivityInstrumentationTestCase2;
        import android.test.suitebuilder.annotation.LargeTest;
        import android.widget.Button;
        import android.widget.TextView;

        import com.jayway.android.robotium.solo.Solo;

        import mds.gpp.saudeemcasa.R;
        import mds.gpp.saudeemcasa.view.ChooseScreen;
        import mds.gpp.saudeemcasa.view.HospitalList;

/**
 * Created by lucas on 11/26/15.
 */
public class ChooseScreenTest extends ActivityInstrumentationTestCase2{
    private Solo solo;

    public ChooseScreenTest() {
        super(ChooseScreen.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testClickMelhorEmCasa() throws Exception{

        Button hospitalButton = (Button) solo.getView(R.id.melhor_em_casa_button);
        solo.clickOnView(hospitalButton);
        solo.assertCurrentActivity("", ChooseScreen.class);
    }

    public void testEquals() throws Exception{
        assertEquals(1, 1);
    }

    public void testBoolean() throws Exception{
        assertTrue(true);
    }
}
