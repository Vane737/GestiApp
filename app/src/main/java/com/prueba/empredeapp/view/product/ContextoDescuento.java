package com.prueba.empredeapp.view.product;

public class ContextoDescuento {

    private DescuentoOrden estrategia;

    public void setEstrategia(DescuentoOrden estrategia) {
        this.estrategia = estrategia;
    }

    public double procesarDescuento( double monto, String tipoCliente) {
        return this.estrategia.realizarDescuento(monto, tipoCliente);
    }
}
