package com.prueba.empredeapp.view.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.prueba.empredeapp.R;
import com.prueba.empredeapp.controller.CCategory;
import com.prueba.empredeapp.controller.CCategoryList;
import com.prueba.empredeapp.model.DCategory;
import com.prueba.empredeapp.model.NCategory;

import org.w3c.dom.Text;

public class VCrearCategoriaActivity extends AppCompatActivity {

    private TextView txtId;
    private TextView txtNombre;
    private TextView txtDescription;
    public Button btnGuardar;
    public Button btnEditar;
    public Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_crear_categoria);

        txtId = (TextView) findViewById(R.id.txtIdCat);
        txtNombre = (TextView) findViewById(R.id.txtNombreCat);
        txtDescription = (TextView) findViewById(R.id.txtDescripcionCat);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        NCategory nc = new NCategory(this);
        CCategory cc = new CCategory(VCrearCategoriaActivity.this, nc);
//        CCategoryList ccl = new CCategoryList(VCrearCategoriaActivity.this, nc);
    }

    // nombre = unnombre, descripcion = "una descripción"
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

    public void setEnableButton( Button btnAction, boolean value ) {
        btnAction.setEnabled(value);
    }
    public void cleanFormData() {

        txtNombre.setText("");
        txtDescription.setText("");
    }

}