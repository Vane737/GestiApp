package com.prueba.empredeapp.model;

import android.content.Context;

public class NCategory {
    DCategory dc;
    Context context;
    public NCategory() {
        dc = new DCategory(this.context);
    }

    public long crear(String nombre) {
        this.dc.setNombre(nombre);
        return dc.agregar();
    }

}
