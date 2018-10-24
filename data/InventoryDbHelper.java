package com.example.puspakbiswas.inventoryapplication.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Puspak Biswas on 24-10-2018.
 */

public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE" + InventoryContract.InventoryEntry.TABLE_NAME+
            "("+ InventoryContract.InventoryEntry._ID+"INTEGER PRIMARY KEY AUTOINCREMENT, "+
            InventoryContract.InventoryEntry.COLUMN_INVENTORY_NAME+ " TEXT NOT NULL, "+
            InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITY+ "INTEGER NOT NULL DEFAULT 0, "+
            InventoryContract.InventoryEntry.COLUMN_INVENTORY_PRICE+ " INTEGER NOT NULL DEFAULT 0, "+
            InventoryContract.InventoryEntry.COLUMN_INVENTORY_IMAGE+ " BLOB);";

    public static final String SQL_DELETE_ENTRIES ="DROP TABLE IF EXISTS "+ InventoryContract.InventoryEntry.TABLE_NAME+";";

    public static final String DATABASE_NAME = "Item.db";
    public static final int DATABASE_VERSION = 1;

    public InventoryDbHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
