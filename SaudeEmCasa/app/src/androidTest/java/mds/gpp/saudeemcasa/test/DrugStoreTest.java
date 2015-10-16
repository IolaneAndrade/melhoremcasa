package mds.gpp.saudeemcasa.test;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by vinisilvacar on 16/10/15.
 */
public class DrugStoreTest extends InstrumentationTestCase{

    public void setUp(){
        DrugStore drug2 = new DrugStore("Pague Menos", "");
        DrugStore drug3 = new DrugStore("Rosario", "3395-1212");
        DrugStore drug4 = new DrugStore("Farmacia", "33818181");

        assertEquals("Pague Menos", drug2.getName());
        assertEquals("", drug2.getTelephone());
        assertEquals("Rosario", drug3.getName());
        assertEquals("3395-1212", drug3.getTelephone());
        assertEquals("Farmacia", drug4.getName());
        assertEquals("33818181", drug4.getTelephone());

    }

    public void testSetPostalCode(){
        //Implementa método de teste unitário: Latitude
        DrugStore d1 = new DrugStore();
        d1.setPostalCode("1212323");
        assertEquals("1212323", d1.getPostalCode());
    }

}
