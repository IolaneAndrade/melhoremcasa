package api.Dao;

import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by vinisilvacar on 16/10/15.
 */
public class DrugStoreDaoTest extends TestCase {
    private static final String COLUMN_DRUG_NAME =  "nameDrug";
    private static final String COLUMN_DRUG_PHONE =  "phoneDrug";

    public void testRegisterUser(){
        try {
            DrugStoreDao drugDao = new DrugStoreDao(); //Erro: acesso privado
            DrugStore drug = new DrugStore("Farmacia", "3321-8181");
            drugDao.insertDrugstore(drug);

            JSONObject jsonObject;
            jsonObject.getJSONObject(drug);

            DrugStore drug2 = new DrugStore(
                    jsonObject.getJSONObject("0").getString(COLUMN_DRUG_NAME),
                    jsonObject.getJSONObject("0").getString(COLUMN_DRUG_PHONE));

            assertTrue(drug.equals(drug2));

            // delete: drugDao.insertAndClose("Farmacia");

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
