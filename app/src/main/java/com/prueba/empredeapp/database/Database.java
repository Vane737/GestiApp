package com.prueba.empredeapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "emprender.db";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE category ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre varchar(50) NOT NULL UNIQUE, " +
                "descripcion varchar(150) NOT NULL)");

        db.execSQL("CREATE TABLE product ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre varchar(50) NOT NULL UNIQUE, " +
                "marca varchar(100), " +
                "categoria_id INTEGER NOT NULL, " +
                "FOREIGN KEY(categoria_id) REFERENCES categoria(id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + "producto");
        db.execSQL("DROP TABLE IF EXISTS " + "categoria");
        onCreate(db);
    }

}
