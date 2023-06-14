package com.prueba.empredeapp.model;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

public class NProduct {

    DProduct dp;
    Context context;

    public NProduct( Context contexto ) {
        this.context = contexto;
        dp = new DProduct(this.context);
    }


    public void setId(String id) {
        this.dp.setId(id);
    }
    public void setNombre( String nombre) {
        this.dp.setNombre(nombre);
    }

    public void setDescripcion( String descripcion) {
        this.dp.setNombre(descripcion);
    }
    public void setPrecio( String precio) {
        this.dp.setNombre(precio);
    }

    public void setIdCategoria( String idCategoria) {
        this.dp.setIdCategoria(idCategoria);
    }

    public long crear( String nombre, String descripcion, String precio) {
        this.dp.setNombre(nombre);
        this.dp.setDescripcion(descripcion);
        this.dp.setPrecio(precio);
        return dp.agregar();
    }

    public int editar(String id, String nombre, String descripcion, String precio, String idCategoria ) {
        this.dp.setId(id);
        this.dp.setNombre(nombre);
        this.dp.setDescripcion(descripcion);
        this.dp.setPrecio(precio);
        this.dp.setIdCategoria(idCategoria);
        return this.dp.editar();
    }

    public String getIdCategoria(){
        return dp.getIdCategoria();
    }
    public int eliminar( String id ) {
        dp.setId(id);
        return this.dp.eliminar();
    }
    public DProduct buscarProduct( String column, String value ) {
        return this.dp.buscarProducto(column, value);
    }
    public List<DProduct> productsList() {
        return dp.listProducts();
    }

}
