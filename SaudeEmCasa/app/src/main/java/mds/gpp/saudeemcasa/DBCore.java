package mds.gpp.saudeemcasa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lucas on 9/22/15.
 */
public class DBCore extends SQLiteOpenHelper {

    private static final String NOME_BD = "NOME";
    private static final int VERSAO_BD = 6;

    public DBCore(Context ctx){
        super(ctx,NOME_BD,null,VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table drugStore(_id integer primary key autoincrement, name text not null, email text not null, adress text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //no use
    }
}
