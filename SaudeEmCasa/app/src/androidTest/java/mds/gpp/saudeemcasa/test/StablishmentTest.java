package mds.gpp.saudeemcasa.test;

import android.test.InstrumentationTestCase;

import mds.gpp.saudeemcasa.model.Stablishment;

/**
 * Created by vinisilvacar on 16/10/15.
 */
public class StablishmentTest extends InstrumentationTestCase{

    public void setUp(){
        Stablishment s1 = new Stablishment("Maria Auxiliadora", "");
        Stablishment s2 = new Stablishment("Maria Auxiliadora", "");
        Stablishment s3 = new Stablishment("Maria Auxiliadora", "");

        assertEquals("Maria Auxiliadora", h1.getName());
        assertEquals("", h1.getTelephone());
        assertEquals("Santa Lucia", h2.getName());
        assertEquals("3581-0012", h2.getTelephone());
        assertEquals("Hospital Regional do Gama", h3.getName());
        assertEquals("33859790", h3.getTelephone());

    }

    public void testSetNumber(){
        //Implementa método de teste unitário: Number
        Hospital h1 = new Hospital();
        h1.setNumber("3711");
        assertEquals("3711", h1.getNumber());
    }

    public void testSetDistrict(){
        //Implementa método de teste unitário: District
        Hospital h1 = new Hospital();
        h1.setDistrict("Federal District");
        assertEquals("Federal District", h1.getDistrict());
    }

}
