package com.prueba.empredeapp.view.product;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.prueba.empredeapp.R;
import com.prueba.empredeapp.controller.CProductList;
import com.prueba.empredeapp.model.DProduct;
import com.prueba.empredeapp.model.NProduct;

import java.util.List;

public class VListarProductosActivity extends AppCompatActivity {

    public Button btnAñadir;
    public Button btnInicio;

    public ListView productosListView;
    private ArrayAdapter<DProduct> productosListAdapter;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlistar_productos);

        btnAñadir = (Button) findViewById(R.id.btn_añadir_prod);
        btnInicio = (Button) findViewById(R.id.btn_inicio_prod);

        productosListView = (ListView) findViewById(R.id.list_view_prod);
        productosListAdapter = new ArrayAdapter<DProduct>(this, R.layout.list_item);
        productosListView.setAdapter(productosListAdapter);
        NProduct np = new NProduct(this);
        CProductList cc = new CProductList(VListarProductosActivity.this, np);
    }

    public void setProductsList(List<DProduct> productsList) {
        productosListAdapter.clear();
        for (int i = 0; i < productsList.size(); i++) {
            System.out.println(productsList.get(i));
            productosListAdapter.add(productsList.get(i));
        }
    }
    public void setIntent(VListarProductosActivity vcl, Context vcc) {
        Intent i = new Intent(vcl, vcc.getClass());
        startActivity(i);
    }

    public void sendProduct(DProduct product, VCrearProductoActivity vcc) {
        Intent i = new Intent(VListarProductosActivity.this, vcc.getClass());
        i.putExtra("id", product.getId());
        i.putExtra("nombre", product.getNombre());
        i.putExtra("descripcion", product.getDescripcion());
        i.putExtra("precio", product.getPrecio());
        i.putExtra("idCategoria", product.getIdCategoria());
        startActivity(i);
    }
    public void mensaggeToast(String mensaje) {
        Toast.makeText(VListarProductosActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }
}