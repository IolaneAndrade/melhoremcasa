package mds.gpp.saudeemcasa.controller;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.Dao.HospitalDao;
import api.Helper.JSONHelper;
import api.Request.HttpConnection;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class HospitalController {

    private static HospitalController instance = null;
    private static Hospital hospital;
    private static List<Hospital> hospitalList = new ArrayList<Hospital>();
    private static HospitalDao hospitalDao;
    private static Context context;

    private HospitalController(Context context) {
        this.context = context;
        hospitalDao = HospitalDao.getInstance(context);
    }

    public static HospitalController getInstance(Context context) {
        if (instance == null) {
            instance = new HospitalController(context);
        } else {
			/* ! Nothing To Do. */
        }
        return instance;
    }
    public void setHospital( Hospital hospital ) {
        HospitalController.hospital = hospital;
    }

    public void updateHospital(String json){
        JSONHelper jsonParser = new JSONHelper();
        List<Hospital> tempHospitalList = null;
        try {
            tempHospitalList = jsonParser.hospitalListFromJSON(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //insert in DB
        Log.e("I did it!", String.valueOf(hospitalList.size()));

        HospitalDao.getInstance(context).insertAllHospitals(tempHospitalList);
        hospitalList = hospitalDao.getAllHospitals();

    }
    public List<Hospital> getAllHospitals(){
        return hospitalList;
    }

    public boolean initControllerHospital() throws IOException, JSONException {
        try {
            if (hospitalDao.isDbEmpty()) {
                //creating
                HttpConnection httpConnection = new HttpConnection(context,"hospital");
                //requesting
                    httpConnection.execute("http://159.203.95.153:3000/habilitados");

                return true;
            } else {
                //just setting hospitals to local list
                hospitalList = hospitalDao.getAllHospitals();
                return true;
            }
        }catch (Exception e){
            return false;
        }

    }

}


