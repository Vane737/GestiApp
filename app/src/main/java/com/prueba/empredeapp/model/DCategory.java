package com.prueba.empredeapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import androidx.annotation.Nullable;

import com.prueba.empredeapp.database.Database;

public class DCategory{

    private String id;
    private String nombre;
    private String descripcion;


    private SQLiteDatabase db;


    public DCategory(SQLiteDatabase db)
    {
        this.id = "";
        this.nombre = "";
        this.descripcion = "";
        this.db = db;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

    public long agregar() {
        long id = 0;
        try {

            ContentValues values = new ContentValues();
            values.put("nombre", this.nombre);
            values.put("descripcion", this.descripcion);

            id = db.insert("category", null, values );

        } catch (Exception ex) {
            System.out.println(ex);
            ex.toString();
        }

        return id;
    }

}
