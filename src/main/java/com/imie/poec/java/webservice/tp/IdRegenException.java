package com.imie.poec.java.webservice.tp;

public class IdRegenException extends Exception {
    private static final long serialVersionUID = 1L;

    public IdRegenException() {
        super();
//        this("Impossible to generate the id of entity a second time!");
    }

    public IdRegenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IdRegenException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdRegenException(String message) {
        super(message);
    }

    public IdRegenException(Throwable cause) {
        super(cause);
    }
}
