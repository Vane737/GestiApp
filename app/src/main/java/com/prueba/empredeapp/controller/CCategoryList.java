package com.prueba.empredeapp.controller;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.prueba.empredeapp.MainActivity;
import com.prueba.empredeapp.R;
import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;
import com.prueba.empredeapp.view.category.VListarCategoriasActivity;

public class CCategoryList {

    NCategory nc;
    VListarCategoriasActivity vc;
//    VCrearCategoriaActivity vcc;
    public CCategoryList(VListarCategoriasActivity vc, NCategory nc ) {
        this.nc = nc;
        this.vc = vc;
        initListener();
    }

    public CCategoryList(VCrearCategoriaActivity vcc, NCategory nc ) {
        this.nc = nc;
        //this.vcc = vcc;
        initListener();
        vc.setCategoriesList(nc.categoriesList());
    }

    public void initListener() {

        vc.btnAñadir.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                VCrearCategoriaActivity vcc = new VCrearCategoriaActivity();
                vc.setIntent(vc, vcc);
            }
        });
/*        vc.categoriasListView(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id = ((DCategory) vc.categoriasListView.getItemAtPosition(i)).getId();
                vc.sendCategory(nc.buscarCategory(id));
            }
        });

*/
    }
}
