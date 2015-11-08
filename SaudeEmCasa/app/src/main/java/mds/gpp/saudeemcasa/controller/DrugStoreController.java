package mds.gpp.saudeemcasa.controller;

import android.content.Context;

import org.json.JSONException;
import android.location.Location;

import junit.framework.TestCase;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import api.Dao.DrugStoreDao;
import api.Exception.ConnectionErrorException;
import api.Helper.JSONHelper;
import api.Request.HttpConnection;
import mds.gpp.saudeemcasa.helper.GPSTracker;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Stablishment;

import static java.util.Collections.sort;


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

    public List<DrugStore> getAllDrugstores(){
        return drugStoreList;
    }

    //this is the main method for all backend work
    public void initControllerDrugstore() throws IOException, JSONException,ConnectionErrorException {

            if (drugStoreDao.isDbEmpty()) {

                HttpConnection httpConnectionPublic = new HttpConnection();
                //requesting public drugstore
                String jsonPublic = httpConnectionPublic.newRequest("http://159.203.95.153:3000/farmacia_popular");

                HttpConnection httpConnectionPrivate = new HttpConnection();
                //requesting private drugstore
                //String jsonPrivate = httpConnectionPrivate.newRequest("http://159.203.95.153:3000/farmacia_popular_conveniada");
                String jsonPrivate = loadJSONFromAsset("json_drugstore_test_data_2.json");
                //if both were  sucessful
                if(jsonPublic != null && jsonPrivate !=null){

                    JSONHelper jsonParser = new JSONHelper(context);
                    //Json parser and database insert
                    //this way there is no more error of memory stack
                    System.out.println("Here");
                    if(jsonParser.drugstorePublicListFromJSON(jsonPublic) && jsonParser.drugstorePrivateListFromJSON(jsonPrivate)){
                        drugStoreList = drugStoreDao.getAllDrugStores();
                    }else{/*error introducing to database*/}
                }else {/*error on connection*/}

            } else {
                //just setting DrugStores to local list
                drugStoreList = drugStoreDao.getAllDrugStores();
            }
    }

    public static int[] setDistance(Context context,ArrayList<DrugStore> list) {
        int[] results = new int[list.size()];
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
            sort(list, new DistanceComparator());
            return results;
        }else {
            return null;
        }

    }
    public String loadJSONFromAsset(String jsonfile) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(jsonfile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
    public static class DistanceComparator implements Comparator<Stablishment>
    {


        public int compare(Stablishment stablishment1, Stablishment stablishment2) {
            return stablishment1.getDistance()<(stablishment2.getDistance())? -1 : 1;
        }

    }
}
