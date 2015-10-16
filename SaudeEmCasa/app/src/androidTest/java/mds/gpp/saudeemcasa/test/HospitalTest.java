package mds.gpp.saudeemcasa.test;

import android.test.InstrumentationTestCase;

import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by vinisilvacar on 16/10/15.
 */
public class HospitalTest extends InstrumentationTestCase{

    public void setUp(){
        Hospital h1 = new Hospital("Maria Auxiliadora", "");
        Hospital h2 = new Hospital("Santa Lucia", "3581-0012");
        Hospital h3 = new Hospital("Hospital Regional do Gama", "33859790");

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
