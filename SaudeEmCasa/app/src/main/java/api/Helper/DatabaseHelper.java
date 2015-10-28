package api.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by lucas on 9/22/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    private static final String DATABASE_NAME = "saudeEmCasaManager";
    private static final int DATABASE_VERSION = 7;
    //tables
//   private static final String USER_TABLE = "[User]";
//    private static final String STABLISHMENT_TABLE = "[Stablishment]";
    private static final String DRUGSTORE_TABLE = "[Drugstore]";
    private static final String HOSPITAL_TABLE = "[Hospital]";
//    private static final String COMMENT_TABLE = "[Comment]";
    //USER
//    private static final String USER_ID = "[userId]";
//    private static final String USER_EMAIL = "[emailUser]";
//    private static final String USER_NAME = "[nameUser]";
//    private static final String USER_BIRTH_DATE = "[birthDateUser]";
//    //STABLISHMENT
//    private static final String STABLISHMENT_ID = "[stablishmentId]";
//    private static final String STABLISHMENT_LATITUDE = "[latitude]";
//    private static final String STABLISHMENT_LONGETUDE = "[longitude]";
//    private static final String STABLISHMENT_CITY = "[city]";
//    private static final String STABLISHMENT_ADDRESS = "[address]";
//    private static final String STABLISHMENT_STATE = "[state]";
//    private static final String STABLISHMENT_RATE = "[rate]";
//    private static final String STABLISHMENT_TELEPHONE = "[telephone]";
//    private static final String STABLISHMENT_NAME = "[name]";
//    private static final String STABLISHMENT_TYPE = "[type]";
//    //DRUGSTORE
    private static final String DRUGSTORE_LATITUDE = "[latitude]";
    private static final String DRUGSTORE_LONGETUDE = "[longitude]";
    private static final String DRUGSTORE_CITY = "[city]";
    private static final String DRUGSTORE_ADDRESS = "[address]";
    private static final String DRUGSTORE_STATE = "[state]";
    private static final String DRUGSTORE_RATE = "[rate]";
    private static final String DRUGSTORE_TELEPHONE = "[telephone]";
    private static final String DRUGSTORE_NAME = "[name]";
    private static final String DRUGSTORE_TYPE = "[type]";
    private static final String DRUGSTORE_ID = "[drugstoreId]";
    private static final String DRUGSTORE_POSTALCODE = "[postalCode]";
    //HOSPITAL
    private static final String HOSPITAL_LATITUDE = "[latitude]";
    private static final String HOSPITAL_LONGETUDE = "[longitude]";
    private static final String HOSPITAL_CITY = "[city]";
    private static final String HOSPITAL_ADDRESS = "[address]";
    private static final String HOSPITAL_STATE = "[state]";
    private static final String HOSPITAL_RATE = "[rate]";
    private static final String HOSPITAL_TELEPHONE = "[telephone]";
    private static final String HOSPITAL_NAME = "[name]";
    private static final String HOSPITAL_TYPE = "[type]";
    private static final String HOSPITAL_ID = "[hospitalId]";
    private static final String HOSPITAL_NUMBER = "[number]";
    private static final String HOSPITAL_DISTRICT = "[district]";
    //COMMENT
//    private static final String COMMENT_ID = "[commentId]";
//    private static final String COMMENT_TEXT = "[textComment]";
//    private static final String COMMENT_DATE = "[dateComment]";
    //CREATING TABLES
//    private static final String CREATE_USER = "CREATE TABLE " + USER_TABLE + " ( " +
//            USER_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
//            USER_NAME + " VARCHAR(15)," + USER_EMAIL + "  VARCHAR(30), " + USER_BIRTH_DATE + " DATE(15));";
//
//    private static final String CREATE_STABLISHMENT = "CREATE TABLE " + STABLISHMENT_TABLE + " ( " +
//            STABLISHMENT_ID + "  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + STABLISHMENT_LATITUDE + "  VARCHAR(10), "+
//            STABLISHMENT_LONGETUDE + " VARCHAR(10), "+STABLISHMENT_TELEPHONE + " VARCHAR(15), "+ STABLISHMENT_CITY + " VARCHAR(20), " +
//            STABLISHMENT_NAME + " VARCHAR(70), "+STABLISHMENT_TYPE + " VARCHAR(10), "+ STABLISHMENT_ADDRESS + " VARCHAR(20), " +
//            STABLISHMENT_STATE + " VARCHAR(20), " + STABLISHMENT_RATE + " FLOAT);";

    private static final String CREATE_DRUGSTORE = "CREATE TABLE " + DRUGSTORE_TABLE + " (" +
            DRUGSTORE_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + DRUGSTORE_POSTALCODE + " VARCHAR(15), " +
            DRUGSTORE_LATITUDE + "  VARCHAR(10), "+ DRUGSTORE_LONGETUDE +
            " VARCHAR(10), "+DRUGSTORE_TELEPHONE + " VARCHAR(15), "+ DRUGSTORE_CITY + " VARCHAR(20), " +
            DRUGSTORE_NAME + " VARCHAR(70), "+DRUGSTORE_TYPE + " VARCHAR(10), "+ DRUGSTORE_ADDRESS + " VARCHAR(20), " +
            DRUGSTORE_STATE + " VARCHAR(20), " + DRUGSTORE_RATE + " FLOAT);";

    private static final String CREATE_HOSPITAL = "CREATE TABLE " + HOSPITAL_TABLE + " ( " + HOSPITAL_ID + "INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            HOSPITAL_NUMBER + " VARCHAR(10), " + HOSPITAL_DISTRICT + " VARCHAR(50), " +
            HOSPITAL_LATITUDE + "  VARCHAR(10), "+
            HOSPITAL_LONGETUDE + " VARCHAR(10), "+HOSPITAL_TELEPHONE + " VARCHAR(15), "+ HOSPITAL_CITY + " VARCHAR(20), " +
            HOSPITAL_NAME + " VARCHAR(70), "+HOSPITAL_TYPE + " VARCHAR(10), "+ HOSPITAL_ADDRESS + " VARCHAR(20), " +
            HOSPITAL_STATE + " VARCHAR(20), " + HOSPITAL_RATE + " FLOAT);";
//
//    private static final String CREATE_COMMENT = "CREATE TABLE " + COMMENT_TABLE + " ( " +
//            COMMENT_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + COMMENT_TEXT + " varchar(400), " +
//            COMMENT_DATE + " DATE, [idUser] INTEGER NOT NULL CONSTRAINT [idUser] REFERENCES " + USER_TABLE + "(" + USER_ID + "), " +
//            "[idStablishment] INT NOT NULL CONSTRAINT [idStablishment] REFERENCES " + STABLISHMENT_TABLE + "(" + STABLISHMENT_ID + "));";
//
    //CONSTRUCTOR
    //public DatabaseAdapter(Context ctx) {
      //  dbHelper = new DatabaseHelper(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    //}

    public DatabaseHelper(Context ctx, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_USER);
//        db.execSQL(CREATE_STABLISHMENT);
        db.execSQL(CREATE_DRUGSTORE);
        db.execSQL(CREATE_HOSPITAL);
//        db.execSQL(CREATE_COMMENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {/*Do nothing*/}

    public DatabaseHelper open() throws SQLException {
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return this;
    }
}