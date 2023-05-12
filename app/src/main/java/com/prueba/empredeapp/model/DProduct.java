package com.prueba.empredeapp.model;

import static java.lang.Integer.parseInt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.prueba.empredeapp.database.Database;

import java.util.LinkedList;
import java.util.List;

public class DProduct {
    private String id;
    private String nombre;
    private String marca;
    private String descripcion;
    private String precio;

    private String idCategoria;

    public DProduct(Context context)
    {
        this.id = "";
        this.nombre = "";
        this.marca = "";
        this.descripcion = "";
        this.precio = "";
        this.idCategoria = "";
        this.contexto = context;
    }

    public DProduct(String id, String nombre, String marca, String descripcion, String precio, String idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idCategoria = idCategoria;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    private Context contexto;

    @Override
    public String toString() {
        return  id + ".- " +
                " NOMBRE:" + nombre.toUpperCase() + '\n' +
                "MARCA:" + marca.toUpperCase() + '\n' +
                "DESCRIPCION:" + descripcion.toUpperCase() + '\n' +
                "PRECIO:" + precio + "  -  " +
                "IDCATEGORIA:" + idCategoria;
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
            values.put("marca", this.marca);
            values.put("descripcion", this.descripcion);
            values.put("precio", Double.parseDouble(this.precio));
            values.put("categoria_id",  parseInt(this.idCategoria));
            id = db.insert("product", null, values );

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
            values.put("descripcion", this.descripcion);
            values.put("precio", Double.parseDouble(precio));
            values.put("categoria_id",  parseInt(this.idCategoria));

            id = db.update("product", values, "id=" + this.id, null) ;
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
            id = db.delete("product", "id=" + this.id, null);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.toString();
        } finally {
            db.close();
        }

        return id;
    }

    public DProduct buscarProducto() {

        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = String.format("select * from product where %s='%s';", "id" , id);
        Cursor row = db.rawQuery(sql, null);
        if (row.moveToFirst()) {
            setId( row.getString(0) );
            setNombre(row.getString(1));
            setMarca(row.getString(2));
            setDescripcion(row.getString(3));
            setPrecio(row.getString(4));
            setIdCategoria(row.getString(5));
        }
        return this;
    }
    public List<DProduct> listProducts() {
        Database dbHelper = new Database(this.contexto);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<DProduct> products = new LinkedList<>();

        String sql = String.format("select * from product");
        Cursor rows = db.rawQuery(sql, null);

        if ( rows.moveToFirst() ) {
            do {
                DProduct product = new DProduct(
                        rows.getString(0),
                        rows.getString(1),
                        rows.getString(2),
                        rows.getString(3),
                        rows.getString(4),
                        rows.getString(5)
                );
                products.add( product );
            }while ( rows.moveToNext() );
        }
        return products;
    }


}
