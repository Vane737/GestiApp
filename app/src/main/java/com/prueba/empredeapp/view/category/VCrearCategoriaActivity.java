package com.prueba.empredeapp.view.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.prueba.empredeapp.R;
import com.prueba.empredeapp.controller.CCategory;
import com.prueba.empredeapp.model.NCategory;

public class VCrearCategoriaActivity extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtDescription;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_crear_categoria);

        txtNombre = (TextView) findViewById(R.id.txtNombreCat);
        txtDescription = (TextView) findViewById(R.id.txtDescripcionCat);
        btnGuardar = (Button) findViewById(R.id.btnGuardarCat);

        NCategory nc = new NCategory(this);
        CCategory cc = new CCategory(this, nc);
    }




}