import junit.framework.TestCase;
import junit.framework.TestResult;

import org.junit.Test;

import mds.gpp.saudeemcasa.model.Stablishment;
/**
 * Created by freemanpivo on 10/16/15.
 */
public class TestModelStablishment extends TestCase{

    @Test
    public void testSetLatitude(){
        Stablishment stablishment = new Stablishment();
        String latitude = "10";
        stablishment.setLatitude(latitude);
        assertEquals(stablishment.getLatitude(), "10");
    }

    @Test
    public void testGetLatitude(){
        Stablishment stablishment = new Stablishment();
        stablishment.setLatitude("10");
        assertEquals("10", stablishment.getLatitude());
    }

    @Test
    public void testSetId(){
        Stablishment stablishment = new Stablishment();
        stablishment.setId(1);
        assertTrue(stablishment.getId() == 1);
    }

    @Test
    public void testGetId(){
        Stablishment stablishment = new Stablishment();
        stablishment.setId(1);
        assertEquals(stablishment.getId(), 1);
    }

    @Test
    public void testSetLongitude(){
        Stablishment stablishment = new Stablishment();
        stablishment.setLongitude("20");
        assertTrue(stablishment.getLongitude() == "20");
    }

    @Test
    public void testGetLongitude(){
        Stablishment stablishment = new Stablishment();
        stablishment.setLongitude("20");
        assertEquals(stablishment.getLongitude(), "20");
    }

    @Test
    public void testSetType(){
        Stablishment stablishment = new Stablishment();
        stablishment.setType("SUS");
        assertTrue(stablishment.getType() == "SUS");
    }

    @Test
    public void testGetType(){
        Stablishment stablishment = new Stablishment();
        stablishment.setType("SUS");
        assertEquals(stablishment.getType(), "SUS");
    }
}
