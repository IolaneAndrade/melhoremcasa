package mds.gpp.saudeemcasa.controller;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import android.location.Location;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.Dao.DrugStoreDao;
import api.Helper.JSONHelper;
import api.Request.HttpConnection;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.DrugStore;


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

    public void updateDruStores(String json,int type){
        Log.e("JSON: ", json);
        //JSON
        JSONHelper jsonParser = new JSONHelper();
        //PARSE JSON to object
        List<DrugStore> tempDrugStoreList = null;
        if(type == 0 ) {
            try {
                tempDrugStoreList = jsonParser.drugstorePrivateListFromJSON(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            try {
                tempDrugStoreList = jsonParser.drugstorePublicListFromJSON(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
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
                HttpConnection httpConnection = new HttpConnection(context,"drugstore");
                //requesting
                httpConnection.execute("http://159.203.95.153:3000/farmacia_popular","http://159.203.95.153:3000/farmacia_popular_conveniada");

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

    public static float[] setDistance(Context context,ArrayList<DrugStore> list) {
        float[] results = new float[list.size()];
        GPSTracker gps = new GPSTracker(context);
        if(gps.canGetLocation()) {
            double userLongitude = gps.getLongitude();
            double userLatitude = gps.getLatitude();

            for (int i = 0; i < list.size(); i++) {
                String auxLatitude = list.get(i).getLatitude();
                String auxLongitude = list.get(i).getLongitude();
                float resultsadapter[] = new float[1];
                Double.parseDouble(auxLongitude);
                Location.distanceBetween(Double.parseDouble(list.get(i).getLatitude()),
                        Double.parseDouble(list.get(i).getLongitude()),
                        userLatitude, userLongitude, resultsadapter);
                list.get(i).setDistance(resultsadapter[0]);
            }
            return results;
        }else {
            return null;
        }

    }
}
