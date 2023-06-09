package com.prueba.empredeapp.view.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.prueba.empredeapp.R;
import com.prueba.empredeapp.controller.CCategory;
import com.prueba.empredeapp.controller.CCategoryList;
import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;
import com.prueba.empredeapp.view.product.Input;

import org.w3c.dom.Text;

public class VCrearCategoriaActivity extends AppCompatActivity {

    private TextView txtId;
    private TextView txtNombre;
    private TextView txtDescription;
    public Button btnGuardar;
    public Button btnEditar;
    public Button btnEliminar;
    private Bundle extras;

    private Input textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_crear_categoria);

        textInput = new Input(this);

        txtId = (TextView) findViewById(R.id.txtIdCat);
        txtId.setEnabled(false);
        txtNombre = (TextView) findViewById(R.id.txtNombreCat);
        txtDescription = (TextView) findViewById(R.id.txtDescripcionCat);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        extras = getIntent().getExtras();
        if (extras != null ) {
            btnGuardar.setEnabled(false);
            txtId.setText(extras.getString("id"));
            txtNombre.setText(extras.getString("nombre"));
            txtDescription.setText(extras.getString("descripcion"));
        }
        if (extras == null ) {
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
        NCategory nc = new NCategory(this);
        CCategory cc = new CCategory(VCrearCategoriaActivity.this, nc);

        Input input = textInput.clonar();

    }


    public String getTextId() {
        return txtId.getText().toString();
    }
    public String getTextNombre() {
        return txtNombre.getText().toString();
    }
    public String getTextDescriocion() {
        return txtDescription.getText().toString();
    }
    public void mensaggeToast(String mensaje) {
        Toast.makeText(VCrearCategoriaActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void cleanFormData() {
        txtId.setText("");
        txtNombre.setText("");
        txtDescription.setText("");
    }



}