package com.prueba.empredeapp.controller;

import android.view.View;
import android.widget.Toast;

import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;
import com.prueba.empredeapp.view.product.Whatsapp;

public class CCategory {
    private NCategory nc;
    private VCrearCategoriaActivity vc;

    public CCategory( VCrearCategoriaActivity vc, NCategory nc ) {
        this.nc = nc;
        this.vc = vc;
        initListener();
    }

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

    public void initListener() {
        vc.btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // guardar();
                Whatsapp whatsapp = new Whatsapp(vc);
                whatsapp.showDialog();
            }
        });
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



    }
