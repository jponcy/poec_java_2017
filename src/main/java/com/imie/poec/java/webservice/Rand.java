package com.imie.poec.java.webservice;

import java.util.Random;

public class Rand {
    private int value;

    public Rand() {
        this(1000);
    }

    public Rand(int max) {
        this.setValue((new Random()).nextInt(max));
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /*
    public int getToto() { // Works.
        return this.value;
    }

    @JsonIgnore
    public String getTest() { // Ignored due to annotation.
        return "test";
    }

    public String test2() { // Ignored due to not a getter.
        return "test2";
    }
    */

    /**
     * @param value
     *            the value to set
     */
    private void setValue(int value) {
        this.value = value;
    }
}
