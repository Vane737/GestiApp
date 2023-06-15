package com.prueba.empredeapp.controller;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.prueba.empredeapp.MainActivity;
import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;
import com.prueba.empredeapp.view.category.VListarCategoriasActivity;
import com.prueba.empredeapp.view.product.Whatsapp;

public class CCategory {
    private NCategory nc;
    private VCrearCategoriaActivity vc;
    private VListarCategoriasActivity vcl;

    public CCategory( VCrearCategoriaActivity vc, NCategory nc ) {
        this.nc = nc;
        this.vc = vc;
        initListener1();
    }

    public CCategory(VListarCategoriasActivity vcl, NCategory nc ) {
        this.nc = nc;
        this.vcl = vcl;
        initListener2();
        vcl.setCategoriesList(this.nc.categoriesList());
    }

    /*
    private void guardar() {

        long id = 0;

        if (vc.getTextNombre().length() > 0 && vc.getTextDescriocion().length() > 0 ){
             id = nc.crear(vc.getTextNombre(), vc.getTextDescriocion());
            if (id > 0 ) {
                vc.mensaggeToast("Registro Guardado");
                vc.cleanFormData();
            } else {
                vc.mensaggeToast("Error al guardar el registro");
            }
        } else {
             vc.mensaggeToast("Debe Escrbir datos en todos los campos");
        }

    }
*/
    private void editar() {

        int id = nc.editar(vc.getTextId(), vc.getTextNombre(), vc.getTextDescriocion());

        if (id > 0 ) {
            vc.mensaggeToast("Registro Editado");
            vc.cleanFormData();
        } else {
            vc.mensaggeToast("Error al editar el registro");
        }

    }
    private void eliminar() {

        int id = nc.eliminar(vc.getTextId());
        if (id > 0 ) {
            vc.mensaggeToast("Registro Eliminado");
            vc.cleanFormData();
        } else {
            vc.mensaggeToast("Error al eliminar el registro");
        }

    }
    public void initListener1() {
        /*      vc.btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // guardar();
                Whatsapp whatsapp = new Whatsapp(vc);
                whatsapp.showDialog();
            }
        });

   */
        vc.btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editar();
            }
        });
        vc.btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                eliminar();
            }
        });

    }

    public void initListener2() {

        vcl.btnAñadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VCrearCategoriaActivity vcc = new VCrearCategoriaActivity();
                vcl.setIntent(vcl, vcc);
            }
        });
        vcl.btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity main = new MainActivity();
                vcl.setIntent(vcl, main);
            }
        });
        vcl.categoriasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                VCrearCategoriaActivity vcc = new VCrearCategoriaActivity();
                String id = ((DCategory) vcl.categoriasListView.getItemAtPosition(i)).getId();
                vcl.sendCategory(nc.buscarCategory("id", id), vcc);
            }
        });

    }



    }
