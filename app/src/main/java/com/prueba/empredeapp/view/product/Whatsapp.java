package com.prueba.empredeapp.view.product;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class Whatsapp extends AlertDialog.Builder {

    private Input inputText;
    private LinearLayout layout;

    private TextView txtNombre;
    private TextView txtCliente;
    private TextView txtSeleccionarUbicacion;
    private Spinner ubicacionesSpinner;

    private ArrayAdapter<String> ubicacionesAdapter;

    public Whatsapp(@NonNull Context context) {
        super(context);

        inputText = new Input(context);

        // List<String> ubicaciones = new ArrayList<>();
        // ubicacionesAdapter = new ArrayAdapter<>(context, R.layout.list_item, ubicaciones);

        layout = new LinearLayout(context);

        txtNombre = new TextView(context);
        txtCliente = new TextView(context);
        txtSeleccionarUbicacion = new TextView(context);
        //ubicacionesSpinner = new Spinner(context);
//        ubicacionesSpinner.setAdapter(ubicacionesAdapter);

        txtNombre.setText("Cliente: ");
        txtCliente.setText("sasdasdasd");
        txtSeleccionarUbicacion.setText("Seleccionar Ubicación de Entrega");

        Input inputvar = inputText.clonar();
        Input inputvar2 = inputText.clonar();

        inputvar.setText("clonacion 1");
        inputvar2.setText("clonacion 2");

        layout.addView(txtNombre);
        layout.addView(txtCliente);
        layout.addView(txtSeleccionarUbicacion);
//        layout.addView(ubicacionesSpinner);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.addView(inputvar);
        layout.addView(inputvar2);

        setView(layout);
        setTitle("Seleccionar Ubicación de Entrega")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("Cancelar", null);


    }

    public void setUbicaciones(List<String> nombresUbicaciones){
        ubicacionesAdapter.clear();
        for (int i = 0; i < nombresUbicaciones.size(); i++) {
            ubicacionesAdapter.add(nombresUbicaciones.get(i)) ;
        }
    }

    public void showDialog(){
        AlertDialog dialog = create();
        dialog.show();
    }

}