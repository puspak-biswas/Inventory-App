package com.example.puspakbiswas.inventoryapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.puspakbiswas.inventoryapplication.data.InventoryContract;
import com.example.puspakbiswas.inventoryapplication.data.InventoryDbHelper;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class CatalogActivity extends AppCompatActivity {

    private InventoryDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
    }

    public void buttonClicked(View view){
        mDbHelper = new InventoryDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_filter);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] img = bos.toByteArray();

        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_NAME,"testItem1");
        values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_QUANTITY,5);
        values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_PRICE,20);
        values.put(InventoryContract.InventoryEntry.COLUMN_INVENTORY_IMAGE,img);
        long returnId = db.insert(InventoryContract.InventoryEntry.TABLE_NAME,null,values);

        if(returnId == -1) {
            Toast.makeText(this, "invalid insert", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "valid insert", Toast.LENGTH_SHORT).show();
        }
    }
}
