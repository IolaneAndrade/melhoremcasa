package mds.gpp.saudeemcasa.test;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import junit.framework.TestCase;

import api.Dao.DrugStoreDao;
import mds.gpp.saudeemcasa.model.DrugStore;

import org.mockito.Mockito.mock;


/**
 * Created by vinisilvacar on 21/10/15.
 */
public class DrugDaoTest extends AndroidTestCase {
    private static final String TEST_FILE_PREFIX = "test_";
    DrugStoreDao drugStoreDao;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        drugStoreDao = mock(DrugStoreDao.class);

        //drugStoreDao = new DrugStoreDao.getInstance(getContext());
    }

    public void testInsertDrugStore(){
        //Make a DrugStore object that will serve as our selection criteria.
        DrugStore drugStore = new DrugStore();

        //Populate the commom name attribute of this search criteria
        drugStore.setName("Rosario");
        drugStore.setTelephone("3385-9790");
        System.out.println(drugStore.getName());
        boolean x = drugStoreDao.insertDrugstore(drugStore);
        System.out.println(drugStoreDao.getAllDrugStores().size());
        System.out.println(x);
        assertTrue(drugStoreDao.getAllDrugStores().size()>0);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
