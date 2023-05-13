package com.prueba.empredeapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class NCategory {
    DCategory dc;
    Context context;
    public NCategory( Context contexto ) {
        this.context = contexto;
        dc = new DCategory(this.context);
    }


    public void setId(String id) {
        this.dc.setId(id);
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

    public int editar(String id, String nombre, String descripcion ) {
        this.dc.setId(id);
        this.dc.setNombre(nombre);
        this.dc.setDescripcion(descripcion);
        return this.dc.editar();
    }

    public int eliminar( String id ) {
        dc.setId(id);
        return this.dc.eliminar();
    }

    public DCategory buscarCategory( String column, String value ) {
        return this.dc.buscarCategoria(column, value);
    }

    public String buscarNombreCategory(String id) {
        return this.dc.buscarNombreCategoria(id);
    }
    public List<DCategory> categoriesList() {
        return dc.listCategories();
    }


}
