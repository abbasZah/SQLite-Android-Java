package com.example.chefms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "chefManager";
    // Contacts table name
    private static final String TABLE_CHEFS = "chefs";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }









// Creating Tables

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHEFS_TABLE = "CREATE TABLE " + TABLE_CHEFS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CHEFS_TABLE);
    }





    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHEFS);
// Create tables again
        onCreate(db);
    }









    // Adding new contact
    void addChef(Chef chef) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, chef.getName()); // Contact Name
        values.put(KEY_PH_NO, chef.getPhoneNumber()); // Contact Phone
// Inserting Row
        db.insert(TABLE_CHEFS, null, values);
        db.close(); // Closing database connection
    }











    boolean checkIfExist(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CHEFS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO }, KEY_PH_NO + "=?",
                new String[] { name }, null, null, null, null);
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }









    // Getting All Chefs
    public List<Chef> getAllChefs() {
        List<Chef> chefList = new ArrayList<Chef>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CHEFS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Chef chef = new Chef();
                chef.setId(Integer.parseInt(cursor.getString(0)));
                chef.setName(cursor.getString(1));
                chef.setPhoneNumber(cursor.getString(2));
// Adding chef to list
                chefList.add(chef);
            } while (cursor.moveToNext());
        }
// return contact list
        return chefList;
    }









    // Deleting single contact
    public void deleteChef(Chef chef) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHEFS, KEY_PH_NO + " = ?",
                new String[] { chef.getPhoneNumber() });
        db.close();
    }



}
