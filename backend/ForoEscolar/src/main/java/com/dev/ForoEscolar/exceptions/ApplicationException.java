package com.dev.ForoEscolar.exceptions;

public class ApplicationException extends RuntimeException{

    private String campo;

    public ApplicationException(String mensaje) {
        super(mensaje);
    }

    public ApplicationException(String campo, String mensaje) {
        super(mensaje);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

}
