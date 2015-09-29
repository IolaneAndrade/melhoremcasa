package api.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import api.Helper.DatabaseHelper;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Hospital;

/**
 * Created by lucas on 9/27/15.
 */
public class StablishmentDao extends Dao{

    private static String tableColumns[]={"stablishmentId","latitude","latitude","city","adress","state","rate","telephone","name","type"};

    private static StablishmentDao instance;

    private static String tableName = "Stablishment";

    private StablishmentDao( Context context ) {
        DrugStoreDao.database = new DatabaseHelper( context );
    }

    public static StablishmentDao getInstance( Context context ) {
        if( StablishmentDao.instance != null ) {
			/* !Nothing To Do. */

        } else {
            StablishmentDao.instance = new StablishmentDao( context );
        }

        return StablishmentDao.instance;
    }

    public boolean isDbEmpty(){
        sqliteDatabase = database.getReadableDatabase();

        String query = "SELECT  1 FROM " + tableName;

        Cursor cursor = sqliteDatabase.rawQuery( query, null );

        boolean isEmpty = false;

        if( cursor != null ) {

            if( cursor.getCount() <= 0 ) {
                cursor.moveToFirst();

                isEmpty = true;

            } else {}

        } else {

            isEmpty = true;
        }

        return isEmpty;
    }

    //for drugStore
    public long insertStablishmentGeneric(DrugStore stablishment) {
        //for upgrading
        sqliteDatabase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tableColumns[1], stablishment.getLatitude());
        values.put(tableColumns[2], stablishment.getLongitude());
        values.put(tableColumns[3], stablishment.getCity());
        values.put(tableColumns[4], stablishment.getAddress());
        values.put(tableColumns[5], stablishment.getState());
        values.put(tableColumns[6], stablishment.getRate());
        values.put(tableColumns[7], stablishment.getTelephone());
        values.put(tableColumns[8], stablishment.getName());
        values.put(tableColumns[9], stablishment.getType());

        long id = sqliteDatabase.insert(tableName, null, values);
        Log.e("ADD",sqliteDatabase.getPath());
        DrugStoreDao.getInstance(context).insertDrugstore(stablishment, id);
        return id;
    }
    //for hospital
    public long insertStablishmentGeneric(Hospital stablishment) {
        //for upgrading
        sqliteDatabase = database.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tableColumns[1], stablishment.getLatitude());
        values.put(tableColumns[2], stablishment.getLongitude());
        values.put(tableColumns[3], stablishment.getCity());
        values.put(tableColumns[4], stablishment.getAddress());
        values.put(tableColumns[5], stablishment.getState());
        values.put(tableColumns[6], stablishment.getRate());
        values.put(tableColumns[7], stablishment.getTelephone());
        values.put(tableColumns[8], stablishment.getName());
        values.put(tableColumns[9], stablishment.getType());


        //WHAT ABOUT THe OTHER ONE
        //insert row

        return sqliteDatabase.insert(tableName, null, values);

    }

}


