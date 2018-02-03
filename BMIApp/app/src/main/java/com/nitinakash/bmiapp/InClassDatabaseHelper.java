package com.nitinakash.bmiapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.widget.EditText;

import java.util.Date;

/**
 * Created by nitinakash on 2018-02-03.
 */

public class InClassDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="inclass"; //Name of the DB
    private static final int DB_VERSION = 1; //version of the DB
    public static  final String TABLE_NAME ="PERSON"; // name of table

    public InClassDatabaseHelper(Context context ){
        super(context,DB_NAME, null, DB_VERSION) ; //null id for cursor
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String createStatement="CREATE TABLE "+ TABLE_NAME + "("
                                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "NAME TEXT,"
                                + "PASSWORD TEXT,"
                                + "HEALTH_CARD_NUMB TEXT,"
                                + "DATE INTEGER);";
        System.out.println(createStatement);

        db.execSQL("CREATE TABLE "+ TABLE_NAME + "("
        + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT,"
                + "PASSWORD TEXT,"
                + "HEALTH_CARD_NUMB TEXT,"
                + "DATE INTEGER);");

        Date today = new Date();
        ContentValues personValues= new ContentValues();

        personValues.put("NAME","DAN" );
        personValues.put("PASSWORD","SUPER" );
        personValues.put("HEALTH_CARD_NUMB","1234" );
        personValues.put("DATE",today.getTime() );

        db.insert(TABLE_NAME,null,personValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
