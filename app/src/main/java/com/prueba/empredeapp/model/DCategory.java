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

    public boolean editar() {
        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        boolean isCorrect  = false;
        try {
            ContentValues values = new ContentValues();
            values.put("nombre", this.nombre);
            values.put("descripcion", this.descripcion);

            db.update("categoria", values, "id=" + id, null) ;
            isCorrect = true;
        } catch (Exception ex) {
            System.out.println(ex);
            isCorrect = false;
            ex.toString();

        } finally {
            db.close();
        }

        return isCorrect;
    }

    public boolean eliminar() {
        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        boolean isCorrect  = false;
        try {
            db.delete("categoria", id, null) ;
            isCorrect = true;
        } catch (Exception ex) {
            System.out.println(ex);
            isCorrect = false;
            ex.toString();
        } finally {
            db.close();
        }

        return isCorrect;
    }

    public DCategory buscarCategoria() {

        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = String.format("select * from categoria where %s='%s';", "id" , id);
        Cursor row = db.rawQuery(sql, null);
        if (row.moveToFirst()) {
                    setId( row.getString(0) );
                    setNombre(row.getString(1));
                    setDescripcion(row.getString(2));
        }
        return this;
    }
    public List<DCategory> listCategories() {
        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<DCategory> categories = new LinkedList<>();

        String sql = String.format("select * from categoria");
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
