package com.prueba.empredeapp.controller;

import android.view.View;
import android.widget.AdapterView;

import com.prueba.empredeapp.MainActivity;
import com.prueba.empredeapp.model.DProduct;
import com.prueba.empredeapp.model.NProduct;
import com.prueba.empredeapp.view.product.VCrearProductoActivity;
import com.prueba.empredeapp.view.product.VListarProductosActivity;

public class CProductList {
    NProduct np;
    VListarProductosActivity vp;
    public CProductList(VListarProductosActivity vp, NProduct np ) {
        this.np = np;
        this.vp = vp;
        initListener();
        this.vp.setProductsList(this.np.productsList());
    }

    public void initListener() {
        vp.btnAñadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VCrearProductoActivity vcc = new VCrearProductoActivity();
                vp.setIntent(vp, vcc);
            }
        });
        vp.btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity main = new MainActivity();
                vp.setIntent(vp, main);
            }
        });
        vp.productosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                VCrearProductoActivity vcc = new VCrearProductoActivity();
                String id = ((DProduct) vp.productosListView.getItemAtPosition(i)).getId();
                vp.sendProduct(np.buscarProduct("id", id), vcc);
            }
        });


    }
}
