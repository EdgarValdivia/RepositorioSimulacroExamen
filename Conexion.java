package com.example.edgarvaldivia.xprestamosgingerbread;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by edgarvaldivia on 7/05/16.
 */

public class Conexion extends SQLiteOpenHelper {

    String tabla = "CREATE TABLE Prestamos(id INTEGER PRIMARY KEY AUTOINCREMENT, Articulo VARCHAR(16), Persona VARCHAR(16) )";

    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}