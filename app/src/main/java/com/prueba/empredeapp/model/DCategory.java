package com.prueba.empredeapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import androidx.annotation.Nullable;

import com.prueba.empredeapp.database.Database;

import java.util.LinkedList;
import java.util.List;

public class DCategory{

    private String id;
    private String nombre;
    private String descripcion;
    private Context contexto;

    @Override
    public String toString() {
        return   id + ".-  " +
                "NOMBRE:  " + nombre.toUpperCase() + "  -  "   +
                "DESCRIPCION:  " + descripcion.toUpperCase();
    }
    ;
    public DCategory( Context context)
    {
        this.id = "";
        this.nombre = "";
        this.descripcion = "";
        this.contexto = context;
    }

    public DCategory(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
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


    public long agregar() {
        long id = 0;
        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nombre", this.nombre);
            values.put("descripcion", this.descripcion);

            id = db.insert("category", null, values );

        } catch (Exception ex) {
            System.out.println(ex);
            ex.toString();
        } finally {
            db.close();
        }

        return id;
    }

    public int editar() {
        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int id = 0;
        try {
            ContentValues values = new ContentValues();
            values.put("nombre", this.nombre);
            values.put("descripcion", this.descripcion);

            id = db.update("category", values, "id=" + this.id, null) ;
        } catch (Exception ex) {
            System.out.println(ex);
            ex.toString();

        } finally {
            db.close();
        }

        return id;
    }

    public int eliminar() {
        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int id  = 0;
        try {
            id = db.delete("category", "id=" + this.id, null);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.toString();
        } finally {
            db.close();
        }

        return id;
    }

    public DCategory buscarCategoria(String column, String value) {

        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = String.format("select * from category where %s='%s';", column , value);
        Cursor row = db.rawQuery(sql, null);
        if (row.moveToFirst()) {
                    setId( row.getString(0) );
                    setNombre(row.getString(1));
                    setDescripcion(row.getString(2));
        }
        return this;
    }

    public String buscarNombreCategoria(String value) {

        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = String.format("select * from category where %s='%s';", "id" , value);
        Cursor row = db.rawQuery(sql, null);
        String nombre = "";
        if (row.moveToFirst()) {
            nombre = row.getString(1);
            return nombre;
        }
        return null;
    }
    public List<DCategory> listCategories() {
        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<DCategory> categories = new LinkedList<>();

        String sql = String.format("select * from category");
        Cursor rows = db.rawQuery(sql, null);

        if ( rows.moveToFirst() ) {
            do {
                DCategory category = new DCategory(
                        rows.getString(0),
                        rows.getString(1),
                        rows.getString(2)
                );
                categories.add( category );
            }while ( rows.moveToNext() );
        }
        return categories;
    }





}
