package mds.gpp.saudeemcasa.controller;

import android.content.Context;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.Dao.DrugStoreDao;
import api.Helper.JSONHelper;
import api.Request.HttpConnection;
import mds.gpp.saudeemcasa.model.DrugStore;


/**
 * Created by freemanpivo on 9/20/15.
 */

public class DrugStoreController {

    private static DrugStoreController instance = null;
    private static DrugStore drugStore;
    private static List<DrugStore> drugStoreList = new ArrayList<DrugStore>();
    private static Context context;
    private static DrugStoreDao drugStoreDao;

    private DrugStoreController(Context context) {
        this.context = context;
        drugStoreDao = DrugStoreDao.getInstance(context);
    }

    public static DrugStoreController getInstance(Context context) {
        if (instance == null) {
            instance = new DrugStoreController(context);
        } else {
			/* ! Nothing To Do. */
        }
        return instance;
    }
    public void setDrugStore( DrugStore drugStore ) {
        DrugStoreController.drugStore = drugStore;
    }

    public void updateDruStores(String json){
        //JSON
        JSONHelper jsonParser = new JSONHelper();
        //PARSE JSON to object
        List<DrugStore> tempDrugStoreList = null;

        try {
            tempDrugStoreList = jsonParser.drugstorePrivateListFromJSON(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //insert private drugstores
        drugStoreDao.insertAllDrogstores(tempDrugStoreList);
        //setting DrugStores to local list
        drugStoreList = drugStoreDao.getAllDrugStores();
    }
    public List<DrugStore> getAllDrugstores(){
        return drugStoreList;
    }

    public boolean initControllerDrugstore() throws IOException, JSONException {
        try {
            if (drugStoreDao.isDbEmpty()) {
                //creating
                HttpConnection httpConnection = new HttpConnection(context);
                //requesting
                httpConnection.execute("159.203.95.153:8000/farmacia_popular","159.203.95.153:8000/farmacia_popular_conveniada");

                return true;
            } else {
                //just setting DrugStores to local list
                drugStoreList = drugStoreDao.getAllDrugStores();
                return true;
            }
        }catch (Exception e){
            return false;
        }

    }
    private static String jsonInput = "";
    private static String jsonInput2 = "";

}
