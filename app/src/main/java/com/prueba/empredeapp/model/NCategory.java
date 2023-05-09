package com.prueba.empredeapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class NCategory {
    DCategory dc;
    Context context;
    public NCategory( Context contexto ) {
        this.context = contexto;
        dc = new DCategory(this.context);
    }


    public void setNombre( String nombre) {
        this.dc.setNombre(nombre);
    }

    public void setDescripcion( String descripcion) {
        this.dc.setNombre(descripcion);
    }
    public long crear( String nombre, String descripcion ) {
        this.dc.setNombre(nombre);
        this.dc.setDescripcion(descripcion);
        return dc.agregar();
    }

    public boolean editar(String id, String nombre, String descripcion ) {
        this.dc.setNombre(nombre);
        this.dc.setDescripcion(descripcion);
        return this.dc.editar();
    }

    public boolean eliminar( String id ) {
        dc.setId(id);
        return this.dc.eliminar();
    }
}
