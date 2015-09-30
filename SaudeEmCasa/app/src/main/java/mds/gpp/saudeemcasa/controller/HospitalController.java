package mds.gpp.saudeemcasa.controller;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.Dao.HospitalDao;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by freemanpivo on 9/20/15.
 */
public class HospitalController {

    private static HospitalController instance = null;
    private static Hospital hospital;
    private static List<Hospital> hospitalList = new ArrayList<Hospital>();

    private static HospitalDao hospitalDao;

    private HospitalController(Context context) {
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

    public List<Hospital> getAllDrugstores(){
        return hospitalList;
    }
    public boolean initController() throws IOException {
        Log.e("ALIVEEEEEE","HERE");
        if(hospitalDao.isDbEmpty()){
            BufferedReader reader = null;
            String Jsoninput;

            reader = new BufferedReader(new FileReader("/home/lucas/git/melhoremcasa/SaudeEmCasa/app/src/main/java/JSON/Jsonlist.JSON"));

            Log.e("HEEEEEEEEER ",reader.readLine());
        }

        return true;
    }

}
