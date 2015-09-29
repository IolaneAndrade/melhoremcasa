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

    protected long insertAndClose( SQLiteDatabase sqliteDatabase, String table,
                                   ContentValues values ) {

        long resultInsert = sqliteDatabase.insert( table, null, values );

        sqliteDatabase.close();

        return resultInsert;
    }
}
