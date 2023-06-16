package com.prueba.empredeapp.view.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.prueba.empredeapp.MainActivity;
import com.prueba.empredeapp.R;
import com.prueba.empredeapp.controller.CCategory;
import com.prueba.empredeapp.controller.CCategoryList;
import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;

import java.util.List;

public class VListarCategoriasActivity extends AppCompatActivity {

    public Button btnAñadir;
    public Button btnInicio;

    public ListView categoriasListView;
    private ArrayAdapter<DCategory> categoriasListAdapter;

    private Context context;

    private NCategory nc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlistar_categorias);
        btnAñadir = (Button) findViewById(R.id.btn_añadir);
        btnInicio = (Button) findViewById(R.id.btn_inicio);

        categoriasListView = (ListView) findViewById(R.id.list_view_cat);
        categoriasListAdapter = new ArrayAdapter<DCategory>(this, R.layout.list_item);
        categoriasListView.setAdapter(categoriasListAdapter);
        System.out.println("Hola mundo");
        nc = new NCategory(this);
        CCategory cc = new CCategory(VListarCategoriasActivity.this, nc);
        this.setCategoriesList(nc.categoriesList());
    }


    public void setCategoriesList(List<DCategory> categoriesList) {
        categoriasListAdapter.clear();
        for (int i = 0; i < categoriesList.size(); i++) {
            System.out.println(categoriesList.get(i));
            categoriasListAdapter.add(categoriesList.get(i));
        }
    }
    public void setIntent(VListarCategoriasActivity vcl, Context vcc) {
        Intent i = new Intent(vcl, vcc.getClass());
        startActivity(i);
    }

    public void sendCategory(DCategory category, VCrearCategoriaActivity vcc) {
        Intent i = new Intent(VListarCategoriasActivity.this, vcc.getClass());
        i.putExtra("id", category.getId());
        i.putExtra("nombre", category.getNombre());
        i.putExtra("descripcion", category.getDescripcion());
        startActivity(i);
    }
    public void mensaggeToast(String mensaje) {
        Toast.makeText(VListarCategoriasActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }
}