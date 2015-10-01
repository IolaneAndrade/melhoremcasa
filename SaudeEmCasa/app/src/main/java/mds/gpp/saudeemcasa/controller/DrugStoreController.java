package mds.gpp.saudeemcasa.controller;

import android.content.Context;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.Dao.DrugStoreDao;
import api.Helper.JSONHelper;
import mds.gpp.saudeemcasa.model.DrugStore;


/**
 * Created by freemanpivo on 9/20/15.
 */

public class DrugStoreController {

    private static DrugStoreController instance = null;
    private static DrugStore drugStore;
    private static List<DrugStore> drugStoreList = new ArrayList<DrugStore>();

    private static DrugStoreDao drugStoreDao;

    private DrugStoreController(Context context) {
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

    public List<DrugStore> getAllDrugstores(){
        return drugStoreList;
    }

    public boolean initControllerDrugstore() throws IOException, JSONException {
        try {
            if (drugStoreDao.isDbEmpty()) {
                //getJSON
                //TODO http request should return to JsonList
                String JsonList = jsonInput; //readFile("/home/lucas/git/melhoremcasa/SaudeEmCasa/app/src/main/java/mds/gpp/saudeemcasa/controller/hp");
                //Create JSON helper
                JSONHelper jsonParser = new JSONHelper();
                //PARSE JSON to object
                //TODO there should be two different methods and list for public and private drugstore
                List<DrugStore> tempDrugStoreList = jsonParser.drugstorePrivateListFromJSON(JsonList);

                //insert private drugstores
                drugStoreDao.insertAllDrogstores(tempDrugStoreList);
                JsonList = jsonInput2;
                //Parse public list
                tempDrugStoreList = jsonParser.drugstorePublicListFromJSON(JsonList);
                //insert public drugstores
                drugStoreDao.insertAllDrogstores(tempDrugStoreList);
                //setting DrugStores to local list
                drugStoreList = drugStoreDao.getAllDrugStores();
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
