package edu.utep.cs.cs4330.mypricewatcher.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.cert.TrustAnchor;

public class Database extends SQLiteOpenHelper {
    public static final String databaseName = "items.db";
    public static final String tableName = "itemTable";
    public static final String col0 = "id";
    public static final String col1 = "name";
    public static final String col2 = "url";
    public static final String col3 = "initialPrice";
    public static final String col4 = "currentPrice";
    public static final String col5 = "priceChange";


    public Database(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName +" (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,url TEXT,initialPrice DOUBLE, currentPrice DOUBLE, priceChange DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS " + tableName);
    onCreate(db);
    }

    public boolean insertData(Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(col1, item.name);
        content.put(col2, item.url);
        content.put(col3, item.initialPrice);
        content.put(col4, item.currentPrice);
        content.put(col5, item.priceChange);
        long result = db.insert(tableName, null, content);
        if(result == -1){
            return false;
        }
        return true;
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from "+tableName,null);
        return data;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, "ID = ?",new String[] {id});
    }
}
