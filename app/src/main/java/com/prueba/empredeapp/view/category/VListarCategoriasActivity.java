package com.prueba.empredeapp.view.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.prueba.empredeapp.R;
import com.prueba.empredeapp.controller.CCategoryList;
import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;

import java.util.List;

public class VListarCategoriasActivity extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtDescription;
    public Button btnGuardar;
    public Button btnEditar;
    public Button btnEliminar;

    public ListView categoriasListView;
    private ArrayAdapter<DCategory> categoriasListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlistar_categorias);

        NCategory nc = new NCategory(this);
        CCategoryList cc = new CCategoryList(VListarCategoriasActivity.this, nc);

        categoriasListView = (ListView) findViewById(R.id.list_view_cat);
        categoriasListAdapter = new ArrayAdapter<DCategory>(this, R.layout.list_item);
        categoriasListView.setAdapter(categoriasListAdapter);
    }

    public void setCategoriesList(List<DCategory> categoriesList) {
        categoriasListAdapter.clear();
        for (int i = 0; i < categoriesList.size(); i++) {
            categoriasListAdapter.add(categoriesList.get(i));
        }
    }

    public void setCategory(DCategory category) {
        if (category == null) return;

        txtNombre.setText(category.getNombre());
        txtDescription.setText(category.getDescripcion());
    }
}