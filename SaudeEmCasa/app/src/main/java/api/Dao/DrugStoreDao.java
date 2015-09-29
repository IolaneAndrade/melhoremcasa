package api.Dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import api.Helper.DatabaseHelper;
import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by lucas on 9/27/15.
 */

public class DrugStoreDao extends Dao{

    private static String tableColumns[]={"drugstoreId","postalCode","idStablishment"};

    private static DrugStoreDao instance;

    private static String tableName = "Drugstore";

    private DrugStoreDao( Context context ) {
        DrugStoreDao.database = new DatabaseHelper( context );
    }

    public static DrugStoreDao getInstance( Context context ) {
        if( DrugStoreDao.instance != null ) {
			/* !Nothing To Do. */

        } else {
            DrugStoreDao.instance = new DrugStoreDao( context );
        }

        return DrugStoreDao.instance;
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

    public long insertDrugstore(DrugStore drugStore, long id) {

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put(tableColumns[1], drugStore.getPostalCode());
        values.put(tableColumns[2], id);
        Log.e("PATH:",sqliteDatabase.getPath());
        return sqLiteDatabase.insert(tableName, null, values);
    }
}
