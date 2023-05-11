package com.prueba.empredeapp.controller;

import android.view.View;
import android.widget.Toast;

import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;

public class CCategory {
    NCategory nc;
    VCrearCategoriaActivity vc;

    public CCategory( VCrearCategoriaActivity vc, NCategory nc ) {
        this.nc = nc;
        this.vc = vc;
        initListener();
    }

    private void guardar() {
        long id = nc.crear(vc.getTextNombre(), vc.getTextDescriocion());

        if (id > 0 ) {
            vc.mensaggeToast("Registro Guardado");
            vc.cleanFormData();
        } else {
            vc.mensaggeToast("Error al guardar el registro");
        }

    }

    public void initListener() {
        vc.btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardar();
            }
        });

    }



    }
