package api.Dao;

import android.content.Context;
import android.database.Cursor;

import api.Helper.DatabaseHelper;

/**
 * Created by lucas on 9/27/15.
 */
public class HospitalDao extends Dao{
    private static HospitalDao instance;

    private static String tableColumns[]={"latitude","longitude","city","address","state","rate","postalCode","telephone","name","type"};


    private static String tableName = "Drugstore";

    private HospitalDao( Context context ) {
        HospitalDao.database = new DatabaseHelper( context );
    }

    public static HospitalDao getInstance( Context context ) {
        if( HospitalDao.instance != null ) {
			/* !Nothing To Do. */

        } else {
            HospitalDao.instance = new HospitalDao( context );
        }

        return HospitalDao.instance;
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
