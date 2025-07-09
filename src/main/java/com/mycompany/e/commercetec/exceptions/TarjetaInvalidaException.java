package com.mycompany.e.commercetec.exceptions;

public class TarjetaInvalidaException extends PagoFallidoException {
    private String numeroTarjeta;
    
    public TarjetaInvalidaException(String numeroTarjeta, String razon) {
        super("TXN_INVALID", "Tarjeta", 0.0, razon);
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getNumeroTarjeta() { return numeroTarjeta; }
}