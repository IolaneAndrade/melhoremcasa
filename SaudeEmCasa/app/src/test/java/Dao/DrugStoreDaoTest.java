package Dao;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import Dao.MyAndroidTestCase;
import api.Dao.DrugStoreDao;
import mds.gpp.saudeemcasa.model.DrugStore;


/**
 * Created by vinisilvacar on 23/10/15.
 */
public class DrugStoreDaoTest extends MyAndroidTestCase {

    public void testShouldPass(){
        Context context = getContext();
        DrugStoreDao drugStoreDao = DrugStoreDao.getInstance(context);

        assertNotNull(DrugStoreDao.getInstance(context));

    }

    public void testInsertDrugStore() throws Exception {
            //Make a DrugStore object that will serve as our selection criteria.
            DrugStoreDao drugStoreDao = DrugStoreDao.getInstance(getContext());

        DrugStore drugStore1 = new DrugStore("Rosario", "3385-9790");
        DrugStore drugStore2= new DrugStore("Pague Menos", "3332-1232");
        DrugStore drugStore3 = new DrugStore("Pacheco", "35556767");
        DrugStore drugStore4 = new DrugStore("Posto nº 06", "3234-0001");
        DrugStore drugStore5 = new DrugStore("Drogasil", "35569480");

        //int beforeTotal = drugStoreDao.getAllDrugStores().size();

       drugStoreDao.insertDrugstore(drugStore1);



       // assertEquals(beforeTotal+1, drugStoreDao.getAllDrugStores().size());

        //System.out.println(drugStoreDao.getAllDrugStores().size());

        //assertTrue(drugStoreDao.getAllDrugStores().size()>0);

        }
}
