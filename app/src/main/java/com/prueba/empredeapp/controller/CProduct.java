package com.prueba.empredeapp.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.model.NProduct;
import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;
import com.prueba.empredeapp.view.product.ContextoDescuento;
import com.prueba.empredeapp.view.product.DescuentoCliente;
import com.prueba.empredeapp.view.product.DescuentoEstudiante;
import com.prueba.empredeapp.view.product.DescuentoTerceraEdad;
import com.prueba.empredeapp.view.product.VCrearProductoActivity;

public class CProduct {
    private NProduct np;
    private VCrearProductoActivity vp;
    private NCategory nc;

    private ContextoDescuento estrategia;

    int position;
    public CProduct( VCrearProductoActivity vp, NProduct np, NCategory nc ) {
        this.estrategia = new ContextoDescuento();
        this.np = np;
        this.vp = vp;
        this.nc = nc;
        initListener();
        this.vp.setCategoriesList(this.nc.categoriesList());
    }

    private void guardar() {

        long id = 0;

        if (vp.getTextNombre().length() > 0 && vp.getTextMarca().length() > 0 && vp.getTextDescripcion().length() > 0 && vp.getTextPrecio().length() > 0 ){
            id = np.crear(vp.getTextNombre(), vp.getTextDescripcion(), vp.getTextPrecio());
            System.out.println(np.getIdCategoria());
            if (id > 0 ) {
                vp.mensaggeToast("Registro Guardado");
                vp.cleanFormData();
            } else {
                vp.mensaggeToast("Error al guardar el registro");
            }
        } else {
            vp.mensaggeToast("Debe Escrbir datos en todos los campos");
        }

    }

    private void setidCat(String id) {

    }


    private void editar() {

        int id = np.editar(vp.getTextId(), vp.getTextNombre(), vp.getTextDescripcion(), vp.getTextPrecio(), null );

        if (id > 0 ) {
            vp.mensaggeToast("Registro Editado");
            vp.cleanFormData();
        } else {
            vp.mensaggeToast("Error al editar el registro");
        }

    }
    private void eliminar() {

        int id = np.eliminar(vp.getTextId());
        if (id > 0 ) {
            vp.mensaggeToast("Registro Eliminado");
            vp.cleanFormData();
        } else {
            vp.mensaggeToast("Error al eliminar el registro");
        }

    }
    public void initListener() {
        vp.btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardar();
            }
        });
        vp.btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editar();
            }
        });
        vp.btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                eliminar();
            }
        });

        vp.categoriasListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String codigo = ((String) vp.categoriasListSpinner.getItemAtPosition(i));
                np.setIdCategoria(nc.buscarCategory("nombre", codigo).getId());

                switch (i) {
                    case 0:
                        estrategia.setEstrategia(new DescuentoEstudiante());
                        break;
                    case 1:
                        estrategia.setEstrategia(new DescuentoCliente());
                        break;
                    case 2:
                        estrategia.setEstrategia(new DescuentoTerceraEdad());
                        break;
                }
                estrategia.procesarDescuento(15,"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                vp.mensaggeToast("Debe seleccionar una Categoria");
            }
        });
    }

}
