import junit.framework.TestCase;

import org.junit.Test;

import mds.gpp.saudeemcasa.model.User;

/**
 * Created by iolane on 17/10/15.
 */
public class TestModelUser extends TestCase{

    @Test
    public void testSetIdUser(){
        User user = new User();
        user.setIdUser(23456);
        assertTrue(user.getIdUser() == 23456);
    }

    @Test
    public void testGetIdUser(){
        User user = new User();
        user.setIdUser(23456);
        assertEquals(23456, user.getIdUser());
    }

    @Test
    public void testUser(){
        User user = new User();
        if(user == null){
            assertTrue(false);
        }else {
            assertTrue(true);
        }
    }
}
