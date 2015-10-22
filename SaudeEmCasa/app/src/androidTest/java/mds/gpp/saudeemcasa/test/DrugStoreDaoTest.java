package mds.gpp.saudeemcasa.test;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.test.ServiceTestCase;
import android.util.Log;

import junit.framework.TestCase;

import java.lang.reflect.Method;

import api.Dao.DrugStoreDao;
import api.Helper.DatabaseHelper;

import static org.mockito.Mock;

/**
 * Created by vinisilvacar on 20/10/15.
 *
 */

public class DrugStoreDaoTest extends TestCase{
    private static String tableColumns[]={"latitude","longitude","city","address","state","rate","postalCode","telephone","name","type"};
    private static String drugName;
    private static String drugPhone;
    private static long drugDBAssignId;
    private static String tableName = "Drugstore";

    private DrugStoreDao drugStoreDao;
    private SQLiteDatabase sqLiteDatabase;
    private DatabaseHelper database;

    private static Context context;

    public void testGetIntance() throws Exception {
        Activity act = new Activity();
        //this.drugStoreDao = DrugStoreDao.getInstance(context);
        drugStoreDao = mock(DrugStoreDao.class);
    }

    /*public void testIsDbEmpty() throws Exception {
        if(this.drugStoreDao.isDbEmpty())
            return 1;
        else
            return 0;

    }*/


    public void testInsertDrugstore() throws Exception {
        this.drugStoreDao = DrugStoreDao.getInstance(context);
        database = new DatabaseHelper(drugStoreDao.getContext());

        assertNotNull(drugStoreDao);

        if(drugStoreDao == null) {
            System.out.println("drugstoreDao: null");
        }else {
            System.out.println("drugstoreDao: OK");
        }

/*
        if(dbHelper == null){
            System.out.println("dbHelper is null");
        }else{
            System.out.println("dbHelper is OK");
        }

        if(dbHelper.getWritableDatabase() == null) {
            System.out.println("\n\ndbHelper.getWritableDataBase() is null");
        }else{
            System.out.println("dbHelper.getWritableDataBase() is OK");
        } */

        if(database == null) {
            System.out.println("database: null");
        }else {
            System.out.println("database: OK");
        }

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        if(database == null) {
            System.out.println("database: null");
        }else {
            System.out.println("database: OK");
        }
        assertNotNull(sqLiteDatabase);


        drugName = "Rosario";
        drugPhone = "3385-9790";

        ContentValues contentValues = new ContentValues();
        contentValues.put(tableColumns[8], drugName);
        contentValues.put(tableColumns[7], drugPhone);

        if(contentValues == null) {
            System.out.println("ContentValues is null");
        }else{
            System.out.println("ContentValues is OK");
        }
        assertNotNull(contentValues);



        if(sqLiteDatabase == null){
            System.out.println("sqLiteDataBase is null");
        }else{
            System.out.println("sqLiteDataBase is OK");
        }

        System.out.println("tableName: " + tableName);


        sqLiteDatabase.insert(tableName, null, contentValues);
        assertTrue(drugDBAssignId != 1);
        Log.e("", "testInsertData Pass -ID: " + drugDBAssignId);


    }

}
