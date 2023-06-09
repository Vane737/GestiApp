package com.prueba.empredeapp.view.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.prueba.empredeapp.R;
import com.prueba.empredeapp.controller.CCategory;
import com.prueba.empredeapp.controller.CProduct;
import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.model.NProduct;
import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;

import java.util.ArrayList;
import java.util.List;

public class  VCrearProductoActivity extends AppCompatActivity {

    private TextView txtId;
    private TextView txtNombre;
    private TextView txtMarca;
    private TextView txtDescription;
    private TextView txtPrecio;
    public Button btnGuardar;
    public Button btnEditar;
    public Button btnEliminar;
    public Spinner categoriasListSpinner;
    private ArrayAdapter<String> categoriasListAdapter;
    private Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vcrear_producto);

        txtId = (TextView) findViewById(R.id.txtIdProd);
        txtId.setEnabled(false);
        txtNombre = (TextView) findViewById(R.id.txtNombreProd);

        txtMarca = (TextView) findViewById(R.id.txtMarcaProd);
        txtDescription = (TextView) findViewById(R.id.txtDescripcionProd);
        txtPrecio = (TextView) findViewById(R.id.txtPrecioProd);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        categoriasListSpinner = (Spinner) findViewById(R.id.spinner_cat_prod);
        categoriasListAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item  );
        categoriasListSpinner.setAdapter(categoriasListAdapter);

        NCategory nc = new NCategory(this);
        NProduct np = new NProduct(this);
        CProduct cp = new CProduct(VCrearProductoActivity.this, np, nc);

        extras = getIntent().getExtras();
        if (extras != null ) {
            btnGuardar.setEnabled(false);
            txtId.setText(extras.getString("id"));
            txtNombre.setText(extras.getString("nombre"));
            txtMarca.setText(extras.getString("marca"));
            txtDescription.setText(extras.getString("descripcion"));
            txtPrecio.setText(extras.getString("precio"));
            // categoriasListSpinner.setSelection(position);
        }
        if (extras == null ) {
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }

    }

    public void buscarPosition( String id, List<DCategory> categoriesList ) {
        categoriasListAdapter.clear();
        for (int i = 0; i < categoriesList.size(); i++) {
            categoriasListAdapter.add(categoriesList.get(i).getNombre());
        }
    }

    public String getTextId() {
        return txtId.getText().toString();
    }
    public String getTextNombre() {
        return txtNombre.getText().toString();
    }
    public String getTextMarca() {
        return txtMarca.getText().toString();
    }
    public String getTextDescripcion() {
        return txtDescription.getText().toString();
    }
    public String getTextPrecio() {
        return txtPrecio.getText().toString();
    }

    public void setCategoriesList(List<DCategory> categoriesList) {
        categoriasListAdapter.clear();
        for (int i = 0; i < categoriesList.size(); i++) {
            categoriasListAdapter.add(categoriesList.get(i).getNombre());
        }
    }

    public void mensaggeToast(String mensaje) {
        Toast.makeText(VCrearProductoActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void cleanFormData() {
        txtId.setText("");
        txtNombre.setText("");
        txtMarca.setText("");
        txtDescription.setText("");
        txtPrecio.setText("0.0");
        categoriasListSpinner.setSelection(0);
    }
}