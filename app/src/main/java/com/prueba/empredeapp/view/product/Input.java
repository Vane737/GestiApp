package com.prueba.empredeapp.view.product;

import android.content.Context;
import android.widget.TextView;

public class Input extends androidx.appcompat.widget.AppCompatTextView implements Prototype {


    public Input(Context context) {
        super(context);
    }

    @Override
    public Input clonar() {
        Input input = new Input(this.getContext());
        input.setText(this.getText());
        return input;
    }
}
