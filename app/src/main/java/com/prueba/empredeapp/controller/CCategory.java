package com.prueba.empredeapp.controller;

import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;

public class CCategory {
    NCategory nc;
    VCrearCategoriaActivity vc;

    public CCategory( VCrearCategoriaActivity vc, NCategory nc ) {
        this.nc = nc;
        this.vc = vc;
    }


}
