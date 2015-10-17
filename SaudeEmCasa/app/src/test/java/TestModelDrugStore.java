import junit.framework.TestCase;

import org.junit.Test;

import mds.gpp.saudeemcasa.model.DrugStore;

public class TestModelDrugStore extends TestCase {

    @Test
    public void testSetPostalCode() {
        DrugStore drugStore = new DrugStore();
        drugStore.setPostalCode("2035");
        assertTrue(drugStore.getPostalCode() == "2035");
    }

    @Test
    public void testGetPostalCode() {
        DrugStore drugStore = new DrugStore();
        drugStore.setPostalCode("2034");
        assertEquals("2034", drugStore.getPostalCode());
    }

}
