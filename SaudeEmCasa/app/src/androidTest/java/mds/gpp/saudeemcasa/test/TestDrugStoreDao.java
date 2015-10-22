import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.security.AccessControlContext;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import api.Dao.DrugStoreDao;
import mds.gpp.saudeemcasa.MainActivity;
import mds.gpp.saudeemcasa.controller.DrugStoreController;
import mds.gpp.saudeemcasa.model.DrugStore;

import org.apache.log4j.*;
import org.junit.Before;
import org.junit.Rule;

/**
 * Created by vinisilvacar on 17/10/15.
 */
public class TestDrugStoreDao extends TestCase {

    private static final String COLUMN_DRUG_NAME =  "name";
    private static final String COLUMN_DRUG_PHONE =  "telephone";
    private static Context context;

    private static final Logger LOGGER = Logger.getLogger(TestDrugStoreDao.class);

    private DrugStoreDao drugStoreDao;

    @Before
    public void setUp() {
        Activity activity = new Activity();
        //Contexto está nulo, não recebe instância. Tem que pegar o contexto da aplicação
        this.drugStoreDao = DrugStoreDao.getInstance(activity.getApplicationContext());
        if(context == null)
            System.out.println("Context DrugStoreDao: null");

        if(drugStoreDao == null) {
            System.out.println("DrugStoreDao getInstance: null");
        }else{
            System.out.println("DrugStoreDao getInstance: tem alguma coisa");
        }
    }

    public void testInsertDrugStore(){

        try {

         DrugStore drug = new DrugStore("Farmacia","(61) 3385-9790");

           System.out.println(drug.getName());
           System.out.println(drug.getTelephone());
            System.out.println("\n");

            if(drugStoreDao == null) {
                System.out.println("DrugStoreDao getInstance: null");
            }else{
                System.out.println("DrugStoreDao getInstance: tem alguma coisa");
            }

           drugStoreDao.insertDrugstore(drug);

           /*JSONObject jsonObject = new JSONObject();
           jsonObject.getJSONObject("Farmacia");

           DrugStore drug2 = new DrugStore(
                   jsonObject.getJSONObject("0").getString(COLUMN_DRUG_NAME),
                   jsonObject.getJSONObject("0").getString(COLUMN_DRUG_PHONE));
            */

            DrugStore drug2 = new DrugStore();
           assertTrue(drug.equals(drug2));
                   // delete: drugDao.insertAndClose("Farmacia");

       } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void testInsertDrugstore2(){
        this.save();
    }

    private DrugStore save() {
        DrugStore drug = new DrugStore("Name", "Description");

        this.drugStoreDao.insertDrugstore(drug);

        LOGGER.info("Drug saved " + drug);

        return drug;
    }

    public void testGetAllDrugstores() {

        List<DrugStore> orders = this.drugStoreDao.getAllDrugStores();

        LOGGER.info(orders);

    }
}
