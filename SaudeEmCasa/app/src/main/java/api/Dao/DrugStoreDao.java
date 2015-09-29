package api.Dao;


import android.content.Context;
import android.database.Cursor;

import api.Helper.DatabaseHelper;
import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by lucas on 9/27/15.
 */
public class DrugStoreDao extends Dao{
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
}
