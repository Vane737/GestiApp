package com.prueba.empredeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.prueba.empredeapp.view.category.VCrearCategoriaActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnDirection;
    private ImageButton btnClient;
    private ImageButton btnCategory;
    private ImageButton btnProduct;
    private ImageButton btnDriver;
    private ImageButton btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_category:
                Toast.makeText(this, "Categoria", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, VCrearCategoriaActivity.class);
                startActivity(i);
                break;
        }
    }
}