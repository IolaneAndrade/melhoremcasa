package mds.gpp.saudeemcasa.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mds.gpp.saudeemcasa.model.DrugStore;

/**
 * Created by lucas on 9/22/15.
 */
public class DBCore extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "saudeEmCasaManager";
    private static final int DATABASE_VERSION= 1;
    //tables
    private static final String USER_TABLE = "[User]";
    private static final String STABLISHMENT_TABLE = "[Stablishment]";
    private static final String DRUGSTORE_TABLE = "[Drugstore]";
    private static final String HOSPITAL_TABLE = "[Hospital]";
    private static final String COMMENT_TABLE = "[Comment]";
    //USER
    private static final String USER_ID = "[userId]";
    private static final String USER_EMAIL = "[emailUser]";
    private static final String USER_NAME ="[nameUser]";
    private static final String USER_BIRTH_DATE = "[birthDateUser]";
    //STABLISHMENT
    private static final String STABLISHMENT_ID = "[stablishmentId]";
    private static final String STABLISHMENT_CITY ="[city]";
    private static final String STABLISHMENT_ADDRESS ="[address]";
    private static final String STABLISHMENT_STATE ="[state]";
    private static final String STABLISHMENT_RATE ="[rate]";
    //DRUGSTORE
    private static final String DRUGSTORE_ID = "[drugstoreId]";
    private static final String DRUGSTORE_LATITUDE = "[latitude]";
    private static final String DRUGSTORE_LONGETUDE = "[longitude]";
    private static final String DRUGSTORE_POSTALCODE = "[postalCode]";
    //HOSPITAL
    private static final String HOSPITAL_ID = "[hospitalId]";
    private static final String HOSPITAL_TYPE = "[type]";
    private static final String HOSPITAL_NUMBER = "[number]";
    private static final String HOSPITAL_DISTRICT = "[district]";
    private static final String HOSPITAL_TELEPHONE = "[telephone]";
    private static final String HOSPITAL_NAME = "[name]";
    //COMMENT
    private static final String COMMENT_ID = "[commentId]";
    private static final String COMMENT_TEXT = "[textComment]";
    private static final String COMMENT_DATE = "[dateComment]";
    //CREATING TABLES
    private static final String CREATE_USER = "CREATE TABLE "+USER_TABLE+" ( " +
            USER_ID +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            USER_NAME+" VARCHAR(15),"+USER_EMAIL+"  VARCHAR(30), "+USER_BIRTH_DATE+" DATE(15));";
    private static final String CREATE_STABLISHMENT = "CREATE TABLE "+STABLISHMENT_TABLE+" ( " +
            STABLISHMENT_ID +"  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+STABLISHMENT_CITY+" VARCHAR(20), " +
            STABLISHMENT_ADDRESS+" VARCHAR(20), "+STABLISHMENT_STATE+" VARCHAR(20), "+STABLISHMENT_RATE+" FLOAT);";
    private static final String CREATE_DRUGSTORE = "CREATE TABLE "+DRUGSTORE_TABLE+" ("+DRUGSTORE_LATITUDE+"  VARCHAR(10), " +
            DRUGSTORE_LONGETUDE+" VARCHAR(10), "+DRUGSTORE_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+DRUGSTORE_POSTALCODE+" VARCHAR(15), " +
            "INTEGER NOT NULL CONSTRAINT [idStablishment] REFERENCES "+STABLISHMENT_TABLE+"("+STABLISHMENT_ID+"));";
    private static final String CREATE_HOSPITAL = "CREATE TABLE "+HOSPITAL_TABLE+" ( "+HOSPITAL_ID+"INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            HOSPITAL_TYPE+" VARCHAR(10), "+HOSPITAL_NUMBER+" VARCHAR(10), "+HOSPITAL_DISTRICT+" VARCHAR(50), "+HOSPITAL_TELEPHONE+" VARCHAR(15), "+HOSPITAL_NAME+" VARCHAR(70), " +
            "[idStablishment] INTEGER NOT NULL CONSTRAINT [idStablishment] REFERENCES "+STABLISHMENT_TABLE+"("+STABLISHMENT_ID+"));";
    private static final String CREATE_COMMENT = "CREATE TABLE "+COMMENT_TABLE+" ( " +
            COMMENT_ID+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COMMENT_TEXT+" varchar(400), " +
            COMMENT_DATE+" DATE, [idUser] INTEGER NOT NULL CONSTRAINT [idUser] REFERENCES "+USER_TABLE+"("+USER_ID+"), " +
            "[idStablishment] INT NOT NULL CONSTRAINT [idStablishment] REFERENCES "+STABLISHMENT_TABLE+"("+STABLISHMENT_ID+"));";
    //CONSTRUCTOR
    public DBCore(Context ctx){
        super(ctx,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_STABLISHMENT);
        db.execSQL(CREATE_DRUGSTORE);
        db.execSQL(CREATE_HOSPITAL);
        db.execSQL(CREATE_COMMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //no use
    }

    public long insertDrugStore(DrugStore drugStore){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DRUGSTORE_ID, drugStore.getId());
        values.put(DRUGSTORE_LATITUDE,drugStore.getLatitude());
        values.put(DRUGSTORE_LONGETUDE,drugStore.getLongitude());
        values.put(DRUGSTORE_POSTALCODE,drugStore.getPostalCode());
        //WHAT ABOUT THe OTHER ONE
        //insert row

        return db.insert(DRUGSTORE_TABLE,null,values);
    }
}
