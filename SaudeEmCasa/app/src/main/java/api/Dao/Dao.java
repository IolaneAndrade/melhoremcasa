package api.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import api.Helper.DatabaseHelper;

/**
 * Created by lucas on 9/29/15.
 */
public class Dao {
    protected static DatabaseHelper database;
    protected static SQLiteDatabase sqliteDatabase;
    protected static Context context;

    protected long insertAndClose(SQLiteDatabase sqLiteDatabase, String table, ContentValues values ) {


        System.out.print("sqlite: "+ sqLiteDatabase);
        //System.out.println(database;
        sqLiteDatabase.insert(table, null, values);
        long resultInsert = 1;

        sqLiteDatabase.close();

        return resultInsert;
    }
}
