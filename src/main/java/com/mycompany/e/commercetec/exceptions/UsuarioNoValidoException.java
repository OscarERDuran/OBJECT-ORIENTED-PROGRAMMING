package com.mycompany.e.commercetec.exceptions;

public class UsuarioNoValidoException extends ECommerceException {
    private String campo;
    
    public UsuarioNoValidoException(String campo, String mensaje) {
        super("Error en campo '" + campo + "': " + mensaje, "USUARIO_NO_VALIDO");
        this.campo = campo;
    }
    
    public String getCampo() { return campo; }
}