package com.imie.poec.java.webservice.tp;

public class JsonMessage implements Entity {
    private String message;

    public JsonMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
