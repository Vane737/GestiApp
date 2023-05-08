package com.prueba.empredeapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import androidx.annotation.Nullable;

import com.prueba.empredeapp.database.Database;

public class DCategory extends Database{

    Context contexto;
    private int id;
    private String nombre;
    private String descripcion;

    public DCategory(@Nullable Context context)
    {
        super(context);
        this.contexto = context;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String description) {
        this.descripcion = description;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "DCategory{" +
                "contexto=" + contexto +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public long agregar() {
        long id = 0;
        try {
            Database database = new Database(contexto);
            SQLiteDatabase db = database.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", this.nombre);
            values.put("descripcion", this.descripcion);

            System.out.println(database.getDatabaseName());
            id = db.insert("category", null, values );

        } catch (Exception ex) {
            System.out.println(ex);
            ex.toString();
        }

        return id;
    }

}
