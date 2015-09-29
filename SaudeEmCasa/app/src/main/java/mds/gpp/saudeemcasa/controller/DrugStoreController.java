package mds.gpp.saudeemcasa.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import api.Dao.DrugStoreDao;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Hospital;

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




}