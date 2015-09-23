package mds.gpp.saudeemcasa.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lucas on 9/22/15.
 */
public class DBCore extends SQLiteOpenHelper {

    private static final String NOME_DB = "NOME";
    private static final int VERSAO_DB= 6;

    private static final String CREATE_USER = "CREATE TABLE [User] ( " +
            "[id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "[nameUser] VARCHAR(15), [emailUser] VARCHAR(30), [birthDateUser] DATE(15));";

    private static final String CREATE_STABLISHMENT = "CREATE TABLE [Stablishment] ( " +
            "[id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,[city] VARCHAR(20), " +
            "[address] VARCHAR(20), [state] VARCHAR(20), [rate] FLOAT);";
    private static final String CREATE_DRUGSTORE = "CREATE TABLE [Drugstore] ( [latitude] VARCHAR(10), " +
            "[longitude] VARCHAR(10), [id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, [postalCode] VARCHAR(15), " +
            "[idStablishment] INTEGER NOT NULL CONSTRAINT [idStablishment] REFERENCES [Stablishment]([id]));";
    private static final String CREATE_HOSPITAL = "CREATE TABLE [Hospital] ( [id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "[type] VARCHAR(10), [number] VARCHAR(10), [district] VARCHAR(50), [telephone] VARCHAR(15), [name] VARCHAR(70), " +
            "[idStablishment] INTEGER NOT NULL CONSTRAINT [idStablishment] REFERENCES [Stablishment]([id]));";
    private static final String CREATE_COMMENT = "CREATE TABLE [Comment] ( " +
            "[id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, [textComment] varchar(400), " +
            "[dateComment] DATE, [idUser] INTEGER NOT NULL CONSTRAINT [idUser] REFERENCES [User]([id]), " +
            "[idStablishment] INT NOT NULL CONSTRAINT [idStablishment] REFERENCES [Stablishment]([id]));";
    public DBCore(Context ctx){
        super(ctx,NOME_DB,null,VERSAO_DB);
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
}
