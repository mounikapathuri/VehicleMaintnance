package com.android.mounika.vehiclemaintnance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mounika on 10/12/2017.
 */


    public class VehicleDB extends SQLiteOpenHelper{


        VehicleDB(Context context) {
            super(context,"Vehicledetails", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table Vehicledetails(date DatePicker,amount Number,message Text) ");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

