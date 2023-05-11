package com.prueba.empredeapp.controller;

import android.view.View;
import android.widget.AdapterView;

import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;
import com.prueba.empredeapp.view.category.VListarCategoriasActivity;

public class CCategoryList {

    NCategory nc;
    VListarCategoriasActivity vc;

    public CCategoryList(VListarCategoriasActivity vc, NCategory nc ) {
        this.nc = nc;
        this.vc = vc;
        initListener();
    }

    public void initListener() {
        vc.categoriasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String codigo = ((DCategory) vc.categoriasListView.getItemAtPosition(i)).getId();
                vc.setCategory(nc.buscarCategory(codigo));
            }
        });

    }
}
