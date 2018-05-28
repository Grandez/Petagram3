package com.android.jgg.petagram3.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.jgg.petagram3.R;
import com.android.jgg.petagram3.base.APP;
import com.android.jgg.petagram3.model.Mascota;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {
    private Context context;

    private static DB db = null;

    public static DB getInstance() {
       if (db == null)  db = new DB();
       return db;
    }

    public DB() {
        super(APP.context, DBConfig.DB_NAME, null, DBConfig.DB_VERSION);
        this.context = context;
    }

    public int qryScalar(String qry, String[] parms) {
        Cursor mCount= db.getReadableDatabase().rawQuery(qry, parms);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;
    }

    public int qryInsert(String table, List<ContentValues> values) {
        SQLiteDatabase tmp = this.getWritableDatabase();
        for (ContentValues val : values) {
            tmp.insert(table, null, val);
        }
        tmp.close();
        return values.size();
    }

    public boolean qryInsert(String table, ContentValues values) {
        ArrayList<ContentValues> vals = new ArrayList<ContentValues>();
        vals.add(values);
        return (qryInsert(table, (List) vals) > 0) ? true : false;
    }

    public void qryUpdate(String qry, String[] parms) {
        db.getWritableDatabase().execSQL(qry, parms);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int idx = 0; idx < DBConfig.TABLES_DDL.length; idx++) {
            String sql = "CREATE TABLE " + DBConfig.TABLES_DDL[idx];
            db.execSQL(sql);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int idx = 0; idx < DBConfig.TABLES_NAME.length; idx++) {
            String sql = "DROP TABLE IF EXISTS " + DBConfig.TABLES_NAME[idx];
            db.execSQL(sql);
        }
        onCreate(db);
    }

    public void initDB() {
        List<ContentValues> data = DBConfig.getDefaultData();
        qryInsert(DBConfig.TB_MASCOTAS, data);
        qryInsert(DBConfig.TB_FOTOS, data);
    }
}
