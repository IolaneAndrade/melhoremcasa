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
    public void testSetNameUser(){
        User user = new User();
        user.setNameUser("Amy Lee");
        assertTrue(user.getNameUser() == "Amy Lee");
    }

    @Test
    public void testGetNameUser(){
        User user = new User();
        user.setNameUser("Lzy Hale");
        assertEquals("Lzy Hale", user.getNameUser());
    }

    @Test
    public void testSetEmailUser(){
        User user = new User();
        user.setEmailUser("AmyLee@gmail.com");
        assertTrue(user.getEmailUser() == "AmyLee@gmail.com");
    }

    @Test
    public void testGetEmailUser(){
        User user = new User();
        user.setEmailUser("LzyHale@gmail.com");
        assertEquals("LzyHale@gmail.com", user.getEmailUser());
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
