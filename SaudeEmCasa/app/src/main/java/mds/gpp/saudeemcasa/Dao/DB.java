package mds.gpp.saudeemcasa.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by lucas on 9/22/15.
 */
public class DB {
    private SQLiteDatabase db;

    public DB(Context context){
        DBCore auxDb = new DBCore(context);
        db = auxDb.getWritableDatabase();
    }

    public void insertDrugStore(DrugStore drugStore){

    }
    public void updateDrugStore(DrugStore drugStore){

    }

}
