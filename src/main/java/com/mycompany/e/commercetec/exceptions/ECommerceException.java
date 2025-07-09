package com.mycompany.e.commercetec.exceptions;

public class ECommerceException extends Exception {
    private String codigoError;
    
    public ECommerceException(String mensaje) {
        super(mensaje);
    }
    
    public ECommerceException(String mensaje, String codigoError) {
        super(mensaje);
        this.codigoError = codigoError;
    }
    
    public ECommerceException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
    
    public ECommerceException(String mensaje, String codigoError, Throwable causa) {
        super(mensaje, causa);
        this.codigoError = codigoError;
    }
    
    public String getCodigoError() {
        return codigoError;
    }
}